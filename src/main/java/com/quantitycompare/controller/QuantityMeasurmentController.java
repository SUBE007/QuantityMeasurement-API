package com.quantitycompare.controller;

import com.quantitycompare.model.ParameterDTO;
import com.quantitycompare.services.ConvertStringParameterIntoEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


//GRAM,KILOGRAM,TONNE//CENTIMETER,INCH,FEET,YARD//MILLILITRE,LITRE,GALLON//FAHRENHEIT,CELSIUS
@RestController
@RequestMapping("/quantityMeasurement")
public class QuantityMeasurmentController {
    @Autowired
    ConvertStringParameterIntoEnum parameterIntoEnum;

    @GetMapping("/compareByParam")
    public String compareUnits(@RequestParam(value = "unit1") String unit1, @RequestParam(value = "val1") Double val1,
                               @RequestParam(value = "unit2") String unit2, @RequestParam(value = "val2") Double val2) {
        return parameterIntoEnum.doCompare(unit1, val1, unit2, val2);
    }

    @GetMapping("/compareByBody")
    public String compareUnits(@RequestBody ParameterDTO parameterDTO) {
        return parameterIntoEnum.doCompareByBody(parameterDTO);
    }

    @GetMapping("/addByParam")
    public String addUnits(@RequestParam(value = "unit1") String unit1, @RequestParam(value = "val1") Double val1,
                           @RequestParam(value = "unit2") String unit2, @RequestParam(value = "val2") Double val2) {
        return parameterIntoEnum.doAdd(unit1, val1, unit2, val2);
    }

    @GetMapping("/addByBody")
    public String addUnits(@RequestBody ParameterDTO paramBody) {
        return parameterIntoEnum.doAddByBody(paramBody);
    }
}
