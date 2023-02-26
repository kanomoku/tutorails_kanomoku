package principle.dependenceinversion;

        public class LingLing {
            ICourse course;
            public void setCourse(ICourse course) {
                this.course = course;
            }
            public void study() {
                course.study();
            }
        }
