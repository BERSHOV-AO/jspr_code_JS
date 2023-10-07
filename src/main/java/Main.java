import org.glassfish.grizzly.CompletionHandler;
import org.glassfish.grizzly.EmptyCompletionHandler;
import org.glassfish.grizzly.Grizzly;
import org.glassfish.grizzly.http.multipart.MultipartEntry;
import org.glassfish.grizzly.http.multipart.MultipartEntryHandler;
import org.glassfish.grizzly.http.multipart.MultipartScanner;
import org.glassfish.grizzly.http.server.HttpHandler;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.grizzly.http.server.Request;
import org.glassfish.grizzly.http.server.Response;

import java.io.IOException;
import java.util.logging.Logger;

public class Main {
    private static final Logger LOGGER = Grizzly.logger(Main.class);

    public static void main(String[] args) throws IOException, InterruptedException {
        // Сервер создается вызовом статического метода, createSimpleServer(),
        // в аргументах которого, указываем - docRoot "static" - это папка, в которой хранятся статические файлы
        // которые будут отдаваться автоматом (без изменения), без каких либо добавлений обработчиков.
        final var server = HttpServer.createSimpleServer("static", 9999);
        // Что бы добавить обработчик(Handler), нам нужно создать new HttpHandler
        server.getServerConfiguration().addHttpHandler(new HttpHandler() {
            @Override
            // будут приходить два объекта request, response
            public void service(Request request, Response response) throws Exception {
                // если мы хотим клиенту какую либо информацию отправить, мы будем делать это через response
                // мы отправим клиенту body из двух символов "ok"
                response.getWriter().write("ok");
                //        response.suspend();
                //        MultipartScanner.scan(request, multipartEntry -> {
                //          LOGGER.info(multipartEntry.getContentDisposition().getDispositionParam("name"));
                //          // TODO: handle entry
                //        }, new EmptyCompletionHandler<>() {
                //          @Override
                //          public void completed(Request result) {
                //            response.resume();
                //            try {
                //              response.getWriter().write("ok");
                //            } catch (IOException e) {
                //              e.printStackTrace();
                //            }
                //          }
                //          @Override
                //          public void failed(Throwable throwable) {
                //            response.resume();
                //          }
                //        });
            }
            // указываем mapping, по какому адресу будет срабатывать этот обработчик
        }, "/api");
        // запуск сервера
        server.start();
        // Что бы сервер выключился корректно мы можем подписаться,
        // на завершение работы Runtime.getRuntime().addShutdownHook
        Runtime.getRuntime().addShutdownHook(new Thread(server::shutdown));
        // Что бы у нас консоль не вылетела, мы ее блокируем
        Thread.currentThread().join();
    }
}

