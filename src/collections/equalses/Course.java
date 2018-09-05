package collections.equalses;

import java.util.List;
import java.util.Date;

/**
 Была у нас программа, которая показывала предстоящие курсы университета на телефоне. Эта программа, само собой, имела модельки:
 Course - описывает курс, имя, картинку, преподавателя и т.д.;
 Course.Session - описывает одну сессию курса (например курс Дискретной математики в 2015 году).
 Вам предстоит реализовать метод сравнения, который бы удовлетворял следующим критериям:
 единственное, что нам важно для курса при сравнении это uuid курса;
 с сервера может прийти обновленное имя, обложка, что угодно другое и единственное
 как мы можем сравнить курс с сервера с курсом в локальной БД это его uuid;

 для сессии сравнение немного сложнее - мы должны сравнивать дату начала сессии и курс,
 к которому привязана сессия; только если оба эти значения одинаковы мы будем считать, что сессии также одинаковы.
 */

public class Course {

    private final String uuid;

    private final String name;

    private final List<Session> sessions;

    public Course(final String uuid, final String name, final List<Session> sessions) {
        this.uuid = uuid;
        this.name = name;
        this.sessions = sessions;
    }

    private String getUuid() {
        return uuid;
    }

    public String getName() {
        return name;
    }

    public List<Session> getSessions() {
        return sessions;
    }

    @Override
    public boolean equals(final Object object) {
        // BEGIN (write your solution here)
        if (object == null) return false;
        if (object.getClass() == this.getClass()) {
            Course course = (Course) object;
            if (this.getUuid().equals(course.getUuid())) return true;
        }
        return false;
        // END
    }

    /**
     Метод hashCode должен работать следующим образом:
     если uuid равно null - возвращает 0;
     если uuid пустая строка - возвращает 0;
     в других случаях нужно суммировать все characters в uuid (напомню из курса 101, что тип char - это не более чем число ;) ) и возвращать сумму.
     Что касается класса Session, то в его случае мы должны в качестве hashCode возвращать результат работы метода hashCode у поля startDate(тип Date имеет свой hashCode).
     */

    @Override
    public int hashCode() {
        if (this.getUuid() == null || this.getUuid().length() == 0) return 0;
        int result = 0;
        for (int i = 0; i < getUuid().length(); i++) {
            result += getUuid().charAt(i);
        }
        return result;
    }

    public class Session {

        private final Date startDate;

        Session(final Date startDate) {
            this.startDate = startDate;
        }

        Date getStartDate() {
            return this.startDate;
        }

        Course getCourse() {
            return Course.this;
        }

        @Override
        public boolean equals(final Object object) {
            // BEGIN (write your solution here)
            if (object == null) return false;
            if (object.getClass() == this.getClass()) {

                Session session = (Session) object;

                if (this.getStartDate().equals(session.getStartDate()) &&
                        this.getCourse().equals(session.getCourse())) {
                    return true;
                }
            }
            return false;
            // END
        }
        @Override
        public int hashcode() {
            return this.getStartDate().hashCode();
        }
    }
}

