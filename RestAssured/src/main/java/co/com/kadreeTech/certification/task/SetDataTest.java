package co.com.kadreeTech.certification.task;

import co.com.kadreeTech.certification.models.DataExcel;
import co.com.kadreeTech.certification.utils.SetData;
import net.serenitybdd.annotations.Shared;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;


public class SetDataTest implements Task{

    private String sheet;
    private String scenario;

    public SetDataTest(String sheet, String scenario){
        this.sheet = sheet;
        this.scenario = scenario;
    }

    @Shared
    DataExcel dataExcel;

    @Override
    public <T extends Actor> void performAs(T actor) {
        dataExcel.setSetDeDatos(SetData.test(sheet,scenario));
    }
    public static SetDataTest user(String sheet, String scenario){
        return Tasks.instrumented(SetDataTest.class, sheet, scenario);
    }
}
