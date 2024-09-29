package dev.gautham.rest.restfulwebservices.filtering;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/filtering")
@Tag(name = "Filtering API")
public class FilteringController {

    private static final String GAUTHAM = "gautham";
    private static final String SUVETHA = "suvetha";
    private static final String MAY_16 = "16-05";
    private static final String MAY_18 = "18-05";

    @GetMapping("/static")
    public UserStaticFilterBean staticFiltering() {
        return new UserStaticFilterBean(GAUTHAM, GAUTHAM, MAY_16);
    }

    @GetMapping("/static-list")
    public List<UserStaticFilterBean> getStaticFilteringList() {
        return Arrays.asList(new UserStaticFilterBean(GAUTHAM, GAUTHAM, MAY_16),
                new UserStaticFilterBean(SUVETHA, SUVETHA, MAY_18));
    }

    @GetMapping("/dynamic")
    public MappingJacksonValue dynamicFilterBean() {
        UserDynamicFilterBean userBean = new UserDynamicFilterBean(GAUTHAM, GAUTHAM, MAY_16);
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(userBean);
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("userName","birthDate");
        FilterProvider provider = new SimpleFilterProvider().addFilter("userBeanFilter", filter);
        mappingJacksonValue.setFilters(provider);
        return mappingJacksonValue;
    }

    @GetMapping("/dynamic-list")
    public MappingJacksonValue getDynamicFilteringList(){
        UserDynamicFilterBean userBean1 = new UserDynamicFilterBean(GAUTHAM, GAUTHAM, MAY_16);
        UserDynamicFilterBean userBean2 = new UserDynamicFilterBean(SUVETHA, SUVETHA, MAY_18);
        List<UserDynamicFilterBean> list = Arrays.asList(userBean1, userBean2);
        MappingJacksonValue jacksonValue = new MappingJacksonValue(list);
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("userName","birthDate");
        FilterProvider filters = new SimpleFilterProvider().addFilter("userBeanFilter", filter);
        jacksonValue.setFilters(filters);
        return jacksonValue;
    }
}
