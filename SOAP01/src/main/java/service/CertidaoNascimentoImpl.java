package service;



import java.text.ParseException; 
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import jakarta.jws.WebService;

//Service Implementation Bean (SIB)
@WebService(endpointInterface = "service.CertidaoNascimento")
public class CertidaoNascimentoImpl implements CertidaoNascimento {

    @Override
    public int calcularIdade(String dataNascimentoStr) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false); // valida datas inválidas como 31/02
        int idadeCalculada = 0;
        try {
            Calendar dataNascimento = Calendar.getInstance();
            Date dt = sdf.parse(dataNascimentoStr);
            dataNascimento.setTime(dt);

            Calendar hoje = Calendar.getInstance();
            idadeCalculada = hoje.get(Calendar.YEAR) - dataNascimento.get(Calendar.YEAR);

            // se ainda não fez aniversário neste ano
            if (hoje.get(Calendar.MONTH) < dataNascimento.get(Calendar.MONTH) ||
               (hoje.get(Calendar.MONTH) == dataNascimento.get(Calendar.MONTH) &&
                hoje.get(Calendar.DAY_OF_MONTH) < dataNascimento.get(Calendar.DAY_OF_MONTH))) {
                idadeCalculada--;
            }
        } catch (ParseException e) {
            throw new IllegalArgumentException("Data inválida: " + dataNascimentoStr, e);
        }
        return idadeCalculada;
    }

    @Override
    public String diaSemanaNascimento(String dataNascimentoStr) {
        String[] dias = {"Domingo","Segunda","Terça","Quarta","Quinta","Sexta","Sábado"};
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false);
        try {
            Calendar cal = Calendar.getInstance();
            cal.setTime(sdf.parse(dataNascimentoStr));
            int d = cal.get(Calendar.DAY_OF_WEEK); // 1..7 (Dom..Sáb)
            return dias[d - 1];
        } catch (ParseException e) {
            throw new IllegalArgumentException("Data inválida: " + dataNascimentoStr, e);
        }
    }
}
