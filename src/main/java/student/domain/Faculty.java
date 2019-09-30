package student.domain;

public enum Faculty {
    ELECTRONICS {
        @Override
        public String toString() {
            return "Electronics";
        }
    },

    MATHEMATICS {
        @Override
        public String toString() {
            return "Mathematics";
        }
    },

    SOCIOLOGY {
        @Override
        public String toString() {
            return "Sociology";
        }
    },

    LAW {
        @Override
        public String toString() {
            return "Law";
        }
    }
}
