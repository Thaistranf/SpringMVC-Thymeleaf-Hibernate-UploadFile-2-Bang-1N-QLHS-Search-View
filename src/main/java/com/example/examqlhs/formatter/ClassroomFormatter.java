//package com.example.examqlhs.formatter;
//
//import com.example.examqlhs.model.Classroom;
//import com.example.examqlhs.service.classroom.IClassroomService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.format.Formatter;
//import org.springframework.stereotype.Component;
//
//import java.text.ParseException;
//import java.util.Locale;
//import java.util.Optional;
//@Component
//public class ClassroomFormatter implements Formatter<Classroom> {
//
//    private IClassroomService classroomService;
//    @Autowired
//    public ClassroomFormatter(IClassroomService classroomService){
//        this.classroomService = classroomService;
//    }
//    @Override
//    public Classroom parse(String text, Locale locale) throws ParseException {
//        Optional<Classroom> optionalClassroom = classroomService.findById(Long.parseLong(text));
//        return optionalClassroom.orElse(null);
//    }
//
//    @Override
//    public String print(Classroom object, Locale locale) {
//        return "[" + object.getId() + ", " + object.getClassName() + "]";
//    }
//}
