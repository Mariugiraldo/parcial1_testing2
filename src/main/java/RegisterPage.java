import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterPage extends BasePage{
    private By titulo = By.xpath("//h1[normalize-space()='Crear cuenta']");
    private By nombre = By.id("firstName");
    private By apellido = By.id("lastName");
    private By email = By.id("email");
    private By contrasena = By.id("password");
    private By recontrasena = By.id("repassword");
    private By registrarseBtn = By.className("btn-primario");
    private By exito = By.className("txt-gracias");
    private By confirmarMail = By.className("txt-exito");
    private By nombreObligatorio = By.xpath("(//small[contains(text(),'Este campo es obligatorio')])[1]");
    private By apellidoObligatorio = By.xpath("(//small[contains(text(),'Este campo es obligatorio')])[2]");
    private By mailObligatorio = By.xpath("(//small[contains(text(),'Este campo es obligatorio')])[3]");
    private By contrasenaObligatorio = By.xpath("(//small[contains(text(),'Este campo es obligatorio')])[4]");
    private By recontrasenaObligatorio = By.xpath("(//small[contains(text(),'Este campo es obligatorio')])[5]");
    private By mailRepetido = By.className("form-feedback");

    public RegisterPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public String obtenerTituloRegistro() throws InterruptedException {
        System.out.println("Me encuentro en la página de Registro: " + getText(titulo));
        return this.getText(titulo);
    }

    public void escribirNombre(String name) throws InterruptedException {
        sendText(name, nombre);
    }

    public void escribirApellido(String lastName) throws InterruptedException {
        sendText(lastName, apellido);
    }

    public void escribirMail(String mail) throws InterruptedException {
        sendText(mail, email);
    }

    public void escribirContraseña(String clave) throws InterruptedException {
        sendText(clave, contrasena);
    }

    public void escribirConfirmarContraseña(String clave) throws InterruptedException {
        sendText(clave, recontrasena);
    }

    public void clickRegistrarse() throws InterruptedException {
        click(registrarseBtn);
    }

    public String obtenerMensajeExito() throws InterruptedException {
        System.out.println("Se creo la cuenta: " + getText(exito));
        return this.getText(exito);
    }

    public String obtenerMensajeConfirmarMail() throws InterruptedException {
        System.out.println("Valido el mensaje de confirmar mail: " + getText(confirmarMail));
        return this.getText(confirmarMail);
    }

    public String obtenerMensajeNombreObligatorio() throws InterruptedException {
        System.out.println("Verificar Nombre: " + getText(nombreObligatorio));
        return this.getText(nombreObligatorio);
    }

    public String obtenerMensajeApellidoObligatorio() throws InterruptedException {
        System.out.println("Verificar Apellido: " + getText(apellidoObligatorio));
        return this.getText(apellidoObligatorio);
    }

    public String obtenerMensajeCorreoObligatorio() throws InterruptedException {
        System.out.println("Verificar Correo: " + getText(mailObligatorio));
        return this.getText(mailObligatorio);
    }

    public String obtenerMensajeContraseñaObligatorio() throws InterruptedException {
        System.out.println("Verificar Contraseña: " + getText(contrasenaObligatorio));
        return this.getText(contrasenaObligatorio);
    }

    public String obtenerMensajeConfirmarContraseñaObligatorio() throws InterruptedException {
        System.out.println("Verificar Nombre: " + getText(recontrasenaObligatorio));
        return this.getText(recontrasenaObligatorio);
    }

    public String obtenerMensajeCorreoRepetido() throws InterruptedException {
        System.out.println("Verificar el mensaje de correo repetido: " + getText(mailRepetido));
        return this.getText(mailRepetido);
    }
}
