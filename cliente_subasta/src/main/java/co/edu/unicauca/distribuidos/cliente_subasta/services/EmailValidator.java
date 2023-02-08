package co.edu.unicauca.distribuidos.cliente_subasta.services;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidator {
  private static final Pattern emailPattern =
      Pattern.compile("^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$");

  public static boolean isValid(String email) {
    Matcher matcher = emailPattern.matcher(email);
    return matcher.matches();
  }
}

