class RecruitmentSolution {
    public static void main(String[] args) {
        final String recordType = "Vacancy";

        Record softwareEngineerVacancy = new Record("SoftwareEngineer0001", recordType);
        Record frontEndEngineerVacancy = new Record("FrontEndEngineer0020", recordType);

        softwareEngineerVacancy.submitForApproval();
        softwareEngineerVacancy.approve();
        frontEndEngineerVacancy.submitForApproval();
        frontEndEngineerVacancy.reject();

    }


    static class Service {
        void submitForApproval(String id, String type) {
            System.out.println("Submitted for approval " + type + " : " + id);
        }

        void approve(String id, String type) {
            if (type.equals("Vacancy")) {
                System.out.println("Approved Record: " + id);

            } else {
                System.out.println("Approved Record " + type + " : " + id);
            }
        }

        void reject(String id, String type) {
            if (type.equals("Vacancy")) {
                System.out.println("Rejected Record: " + id);

            } else {
                System.out.println("Rejected Record " + type + " : " + id);
            }
        }
    }

    static class Record {
        private Service service = new Service();
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

        public void submitForApproval() {
            service.submitForApproval(this.id, this.type);
        }

        public void approve() {
            service.approve(this.id, this.type);
        }

        public void reject() {
            service.reject(this.id, this.type);
        }
    }
}
