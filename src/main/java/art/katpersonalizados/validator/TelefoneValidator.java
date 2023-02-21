package art.katpersonalizados.validator;

import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber.PhoneNumber;

@SuppressWarnings("BooleanMethodIsAlwaysInverted")
public class TelefoneValidator {

    public static boolean isValid(String telefone){
        PhoneNumberUtil phoneNumberUtil = PhoneNumberUtil.getInstance();
        try {
            PhoneNumber number = phoneNumberUtil.parse(telefone, "BR");
            return phoneNumberUtil.isValidNumber(number);
        } catch (NumberParseException e){
            return false;
        }
    }
}
