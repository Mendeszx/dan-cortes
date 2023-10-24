package com.app.dancortes.common.utils;

import com.app.dancortes.DanCortesApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Service
public class FunctionsUtils {

    public static LocalDate converterStringParaLocalDate(String dataString) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        LocalDate data = LocalDate.parse(dataString, formatter);

        return data;
    }

    public static Time converterStringParaTime(String horaString) throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");

        Date data = sdf.parse(horaString);

        Time horaTime = new Time(data.getTime());

        return horaTime;
    }

    //gerar senha criptgrafada
    public static void main(String[] args) {
        String senha = new BCryptPasswordEncoder().encode("admin");
        System.out.println(senha);

    }
}
