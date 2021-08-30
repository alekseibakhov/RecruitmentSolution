class RecruitmentSolution {
    public static void main(String[] args) {
        final String recordType = "Vacancy";

        Record softwareEngineerVacancy = new Record("SoftwareEngineer0001", recordType);
        Record frontEndEngineerVacancy = new Record("FrontEndEngineer0020", recordType);
        Service service1 = new Service();
        service1.submitForApproval(softwareEngineerVacancy);
        service1.approve(softwareEngineerVacancy);
        service1.submitForApproval(frontEndEngineerVacancy);
        service1.reject(frontEndEngineerVacancy);
    }


    interface Applicant {
        void submitForApproval(MainClass.Record record);

        void approve(MainClass.Record record);

        void reject(MainClass.Record record);
    }

    static class Vacancy implements Applicant {


        @Override
        public void submitForApproval(Record record) {
            System.out.println("Submitted for approval "+ record.getType()+ " : "  + record.getId() );
        }

        @Override
        public void approve(Record record) {
            System.out.println("Approved Record: " + record.getId());
        }

        @Override
        public void reject(Record record) {
            System.out.println("Rejected Record: " + record.getId());
        }
    }

    static class Service {
        Applicant applicant = null;

        void submitForApproval(Record record) {
            if (record.getId() instanceof String && record.getType() instanceof String) {
                applicant = new Vacancy();
                applicant.submitForApproval(record);
            }
        }

        void approve(Record record) {
            if (record.getId() instanceof String && record.getType() instanceof String) {
                applicant = new Vacancy();
                applicant.approve(record);
            }
        }

        void reject(Record record) {
            if (record.getId() instanceof String && record.getType() instanceof String) {
                applicant = new Vacancy();
                applicant.reject(record);
            }
        }


    }

    static class Record {
        private String id;
        private String type;

        Record(String id, String type) {
            this.id = id;
            this.type = type;
        }

        public String getId() {
            return this.id;
        }

        public String getType() {
            return this.type;
        }


    }

}
