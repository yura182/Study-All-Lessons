package student.domain;

public enum Level {
    FIRST {
        @Override
        public String toString() {
            return "First";
        }
    },

    SECOND {
        @Override
        public String toString() {
            return "Second";
        }
    },

    THIRD {
        @Override
        public String toString() {
            return "Third";
        }
    },

    FOURTH {
        @Override
        public String toString() {
            return "Fourth";
        }
    },

    FIFTH {
        @Override
        public String toString() {
            return "Fifth";
        }
    }
}
