package Controller;

import Model.Vacation;
import Model.UserDatabase;
import View.AbstractView;
import View.PublishVacationView;

import java.time.LocalDate;

public class PublishController extends UserController {


    public PublishController(){

    }


    public void Publish()
    {
        PublishVacationView publishVacationView = (PublishVacationView) view;
        Vacation vacation = userDatabase.getVacation(publishVacationView.getvacationIDText());
        if (vacation == null) {
            userDatabase.addVacation(publishVacationView.getvacationIDText(), publishVacationView.getDestinetionContryTXT(), publishVacationView.getNumOfTicketsTXT(),
                    publishVacationView.getFlightCompanyTXT(), publishVacationView.getBaggageTXT(), publishVacationView.getKindOfVacationTXT(), publishVacationView.getKindOfSleepingPlaceTXT(),
                    publishVacationView.getTheRateOfTheSleepingPlaceTXT(), publishVacationView.getTodateStr(), publishVacationView.getFromdateStr(),
                    publishVacationView.KindOfTicketSTR, publishVacationView.isTheSleepingCostsIncludesSTR, publishVacationView.isThereReturnFlightSTR );
            userView.mainMenu();
            userView.setupView(userDatabase);
        }
        else {
            publishVacationView.setComments("Vacation already exists!");
        }
    }

    public void toDatePicked() {
        PublishVacationView publishVacationView = (PublishVacationView) view;
        LocalDate dateOfVacation = publishVacationView.getToDateTXT();
        if (isLegalDateForVacation(dateOfVacation)) {
            publishVacationView.setToDate(dateOfVacation.toString());
            publishVacationView.KeyReleased();
        } else {
            publishVacationView.setComments("the date of the vacation already passed");
            publishVacationView.cleartoDateTXT();
        }
    }

    public void fromDatePicked() {
        PublishVacationView publishVacationView = (PublishVacationView) view;
        LocalDate dateOfVacation = publishVacationView.getFromDateTXT();
        if (isLegalDateForVacation(dateOfVacation)) {
            publishVacationView.setfromDate(dateOfVacation.toString());
            publishVacationView.KeyReleased();
        } else {
            publishVacationView.setComments("the date of the vacation already passed");
            publishVacationView.clearfromDateTXT();
        }
    }

    public void KindOfTicketPicked() {
        PublishVacationView publishVacationView = (PublishVacationView) view;
        String dateOfVacation = publishVacationView.getKindOfTicketTXT();
        publishVacationView.KindOfTicketSTR=dateOfVacation;
        publishVacationView.KeyReleased();
    }

    public void IsTheSleepingCostsIncludesOfTicketPicked() {
        PublishVacationView publishVacationView = (PublishVacationView) view;
        String dateOfVacation = publishVacationView.getIsTheSleepingCostsIncludesTXT();
        publishVacationView.isTheSleepingCostsIncludesSTR=dateOfVacation;
        publishVacationView.KeyReleased();
    }

    public void IsThereReturnFlightPicked() {
        PublishVacationView publishVacationView = (PublishVacationView) view;
        String dateOfVacation = publishVacationView.getIsThereReturnFlightTXT();
        publishVacationView.isThereReturnFlightSTR=dateOfVacation;
        publishVacationView.KeyReleased();
    }

    /**
     * This function will set the right view for this class
     */
    public void setView(AbstractView abstractView) {

        if(abstractView instanceof PublishVacationView)
            super.setView(abstractView);
        else
        {
            super.setView(null);
        }
    }
}