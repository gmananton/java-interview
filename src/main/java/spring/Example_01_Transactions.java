package spring;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class Example_01_Transactions {


    @RequiredArgsConstructor
    public class SomeService {

        private final SomeOtherService someOtherService;

        @Scheduled
        public void loadAndSave() {
            List<Object> loaded = List.of(1, 2, 3, 4, 5); ///...load a lot of objects from external resource
            //process() and then
            save(loaded);
        }

        @Transactional
        public void save(List<Object> objects) {
            objects.forEach(someOtherService::save);
        }

    }

    @Component
    public class SomeOtherService {

        @Transactional
        public void save(Object object) {
            //save using spring-data and hibernate
        }

    }

}
