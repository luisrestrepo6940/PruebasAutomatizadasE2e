Proyecto de pruebas automatizadas E2E (End-to-End) de interfaz gráfica (GUI) en Java para el flujo de compra en el sitio web https://www.saucedemo.com

Paso a paso para su clonado y configuración en local

Clone el repositorio usando la siguiente instrucción en el destino deseado de su equipo de computo: git clone https://github.com/luisrestrepo6940/PruebasAutomatizadasE2e.git

1. Proceda a abrir el repositorio con IDE preferido. Se recomienda usar IntelliJ IDEA.
2. Diríjase y elija en el menú Files -> Settings -> Build, Execution, Deployment -> Build Tools -> Gradle -> Gradle JVM: Project SDK correto-21. Para aplicar la configuración presione el botón Apply.
3. Diríjase y elija en el menú Files -> Settings -> Build, Execution, Deployment -> Compiler -> Java Compiler -> Project bytecode versión: 21. Para aplicar la configuración presione el botón Apply.
4. Diríjase y elija en el menú Files -> Project Structure -> Project Settings -> Project -> SDK: corretto-21 Amazon Corretto versión 21...Para aplicar la configuración presione el botón Apply.
5. Diríjase y elija en el menú Files -> Project Structure -> Project Settings -> Project -> Languaje level: SDK default. Para aplicar la configuración presione el botón Apply.
6. Diríjase y elija en el menú Files -> Project Structure -> Platform Settings -> + (adicionar) -> corretto-21. Evidenciar que Name: corretto-21 y que la ruta  incluida en JDK home path: ...\.jdks\corretto-21... contenga la versión 21 de corretto.Para aplicar la configuración presione el botón Apply.

Paso a paso para su ejecución en local

Nota: Los navegadores están configurados en el archivo src/test/resources/serenity.conf y tienen la opción "--headless" que indica que las pruebas se van a ejecutar en el navegador elegido pero sin ver la interfaz grafica de usuario en pantalla. Para lanzar la prueba viendo la interfaz grafica de usuario en pantalla se requiere quitar dicha propiedad del apartado "goog:chromeOptions" y/o del apartado "ms:edgeOptions".

Ejecución con test runner CheckoutRunnerByProducts.java generando reporte Serenity Reports en target/site/serenity/index.html:

1. Busque el test runner en la ruta src/test/java/co/com/certification/practiceautomatedtesting/runners/
2. Haga clic derecho sobre el test runner en mención.
3. Elija la opción Run 'CheckoutRunnerByProd...' del menú contextual que se despliega en pantalla.
4. Detenga la ejecución presione el botón Stop 'CheckoutRunnerByProducts'.
5. Haga clic izquierdo sobre Selector de configuraciones de ejecución/depuración(Run/Debug Configuration Selector) y elija la opción Edit Configurations... del menú contextual que se despliega en pantalla.
6. Evidencie que el campo Run contiene :test --tests "co.com.certification.practiceautomatedtesting.runners.CheckoutRunnerByProducts"
7. Haga clic izquierdo sobre Modify Options y en el apartado Java elija Add VM Options.
8. En el campo VM options ingrese -Denvironment=edge para ejecutar con Microsoft Edge o -Denvironment=chrome para ejecutar con Google Chrome.
9. Para aplicar la configuración presione el botón Apply y luego OK.
10. Lance el test runner haciendo clic sobre el botón Run 'CheckoutRunnerByProducts'
11. Espere a que finalice la  ejecución y busque el Serenity Reports en target/site/serenity/index.html
12. Haga clic sobre el archivo index.html y elija el aplicativo con el cuál lo quiere visualizar.

Ejecución por consola gradLe generando reporte Serenity Reports en target/site/serenity/index.html:

1. Diríjase a la barra de herramientas o pestaña de Gradle (Gradle Tool Window).
2. Seleccione la opción Execute Gradle Task.
3. En la consola Run Anything limpie el campo e ingrese solo una de las siguientes opciones y presione enter:
Microsoft Edge -> ./gradlew clean test --tests "co.com.certification.practiceautomatedtesting.runners.CheckoutRunnerByProducts" -Denvironment=edge
Google Chrome -> ./gradlew clean test --tests "co.com.certification.practiceautomatedtesting.runners.CheckoutRunnerByProducts" -Denvironment=chrome
4. Espere a que finalice la  ejecución y busque el Serenity Reports en target/site/serenity/index.html
5. Haga clic sobre el archivo index.html y elija el aplicativo con el cuál lo quiere visualizar.