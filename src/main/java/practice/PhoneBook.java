package practice;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneBook {
    private final HashMap<String, TreeSet<String>> PHONE_BOOK = new HashMap<>();


    public boolean isPhone(String isPhone) {
        Pattern pattern = Pattern.compile("^((8|\\+7)[\\- ]?)?(\\(?\\d{3}\\)?[\\- ]?)?[\\d\\- ]{7,10}$");
        Matcher matcher = pattern.matcher(isPhone);
        return matcher.matches();
    }

    public boolean isName(String isName) {
        Pattern pattern = Pattern.compile("^[A-ЯЁ][а-яё]+$");
        Matcher matcher = pattern.matcher(isName);
        return matcher.matches();
    }

    public void addContact(String phone, String name) {
        if (isPhone(phone) && isName(name)) {
            for (Map.Entry<String, TreeSet<String>> entry : PHONE_BOOK.entrySet()) {
                if (entry.getValue().contains(phone)) {
                    PHONE_BOOK.remove(entry.getKey());
                }
            }
            if (PHONE_BOOK.containsKey(name)) {
                PHONE_BOOK.get(name).add(phone);
            } else {
                TreeSet<String> phones = new TreeSet<>();
                phones.add(phone);
                PHONE_BOOK.put(name, phones);
            }
        }
    }

    public String getContactByPhone(String phone) {
        for (Map.Entry<String, TreeSet<String>> entry : PHONE_BOOK.entrySet()) {
            if (entry.getValue().contains(phone)) {
                String keyName = entry.getKey();
                StringJoiner number = new StringJoiner(",");
                for (String number1 : entry.getValue()) {
                    number.add(number1);
                }
                return keyName + " - " + number;
            }
        }
        return "";
    }

    public Set<String> getContactByName(String name) {
        TreeSet<String> names = new TreeSet<>();
        for (Map.Entry<String, TreeSet<String>> entry : PHONE_BOOK.entrySet()) {
            if (entry.getKey().contains(name)) {
                StringJoiner number = new StringJoiner(", ");
                for (String phone : entry.getValue()) {
                    number.add(phone);
                }
                names.add(name + " - " + number);
                return names;
            }
        }
        return new TreeSet<>();
    }

    public Set<String> getAllContacts() {
        TreeSet<String> allPhones = new TreeSet<>();
        for (Map.Entry<String, TreeSet<String>> entry : PHONE_BOOK.entrySet()) {
            String keyName = entry.getKey();
            Set<String> phoneNumbers = entry.getValue();
            StringJoiner number = new StringJoiner(", ");
            for (String phone : phoneNumbers) {
                number.add(phone);
            }
            allPhones.add(keyName + " - " + number);
        }
        return allPhones;
    }
}