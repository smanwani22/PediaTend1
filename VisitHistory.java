package com.example.pediatendprimary.stash;

class VisitHistory
{
    private String diagnosis, methodology, prescriptions, advice;

    public VisitHistory(String diagnosis, String methodology, String prescriptions, String advice) {
        this.diagnosis = diagnosis;
        this.methodology = methodology;
        this.prescriptions = prescriptions;
        this.advice = advice;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getMethodology() {
        return methodology;
    }

    public String getPrescriptions() {
        return prescriptions;
    }


    public String getAdvice() {
        return advice;
    }

}
