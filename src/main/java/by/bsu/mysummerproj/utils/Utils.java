package by.bsu.mysummerproj.utils;

import lombok.experimental.UtilityClass;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@UtilityClass
public class Utils {
    public static Date convertToValidDate(String inputDate) throws ParseException {

        // Создаем объект DateTimeFormatter для заданного формата входной строки
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        // Преобразуем входную строку в объект LocalDate
        LocalDate date = LocalDate.parse(inputDate, inputFormatter);

        // Создаем объект DateTimeFormatter для желаемого формата выходной строки
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");

        // Преобразуем объект LocalDate в строку в заданном формате
        String outputDate = date.format(outputFormatter);

        return new SimpleDateFormat("yyyy/MM/dd")
                .parse(outputDate);
    }
}
