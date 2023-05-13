import org.w3c.dom.html.HTMLTableRowElement;

public class Main {
    private static final String REGEX = "^[a-zA-Z0-9_]*$";
    public static void main(String[] args) {
        try {
            check("action","12345","12345");
            System.out.println("Проверка прошла успешно");
        } catch (WrongLoginException|WrongPasswordException e) {
            System.out.println(e.getMessage());
        }
        }
        public static void check (String login, String password, String confirmPassword)
            throws
            WrongLoginException, WrongPasswordException{
       if(!login.matches(REGEX)){
           throw new WrongLoginException("В логине не допустимые символы");
       }
        if(login.length()>20){
            throw new WrongLoginException("Размер логина превышает максимально допустимое значение");
        }
        if(!password.matches(REGEX)){
            throw new WrongPasswordException("В пароле не допустимые символы");
        }
        if(password.length()>20){
            throw new WrongPasswordException("Размер пароля превышает максимально допустимое значение");
        }
        if(!password.equals(confirmPassword)){
            throw new WrongPasswordException("Пароли при проверке не совпадают");
        }
    }

}