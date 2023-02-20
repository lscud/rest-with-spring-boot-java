package com.scud.project;


import com.scud.project.converters.NumberConverter;
import com.scud.project.exception.UnsupportedMathOperationException;
import com.scud.project.math.SimpleMath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.beans.SimpleBeanInfo;
import java.util.concurrent.atomic.AtomicLong;


@RestController
public class MathController {

    private final AtomicLong counter = new AtomicLong();


    private SimpleMath math = new SimpleMath();

    @RequestMapping(value="/sum/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double sum(@PathVariable(value = "numberOne") String numberOne, @PathVariable(value = "numberTwo") String numberTwo) {
        if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
                throw new UnsupportedMathOperationException("Error input");
            }
        return math.sum(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
    }

    @RequestMapping(value="/sub/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double sub(@PathVariable(value = "numberOne") String numberOne, @PathVariable(value = "numberTwo") String numberTwo) {
        if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Error input");
        }
        return math.sub(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
    }

    @RequestMapping(value="/prod/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double prod(@PathVariable(value = "numberOne") String numberOne, @PathVariable(value = "numberTwo") String numberTwo) {
        if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Error input");
        }
        return math.prod(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
    }

    @RequestMapping(value="/div/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double div(@PathVariable(value = "numberOne") String numberOne, @PathVariable(value = "numberTwo") String numberTwo) {
        if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Error input");
        }
        return math.div(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
    }

    @RequestMapping(value="/med/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double med(@PathVariable(value = "numberOne") String numberOne, @PathVariable(value = "numberTwo") String numberTwo) {
        if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Error input");
        }
        return math.med(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
    }

    @RequestMapping(value="/squa/{numberOne}", method = RequestMethod.GET)
    public Double squa(@PathVariable(value = "numberOne") String numberOne) {
        if (!NumberConverter.isNumeric(numberOne)) {
            throw new UnsupportedMathOperationException("Error input");
        }
        return math.squa(NumberConverter.convertToDouble(numberOne));
    }

}
