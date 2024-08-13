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
@Tag(name = "FilteringController")
public class FilteringController {

    @GetMapping("/static")
    public UserStaticFilterBean staticFiltering() {
        return new UserStaticFilterBean("gautham", "gautham", "16-05");
    }

    @GetMapping("/static-list")
    public List<UserStaticFilterBean> getStaticFilteringList() {
        return Arrays.asList(new UserStaticFilterBean("gautham", "gautham", "16-05"),
                new UserStaticFilterBean("suvetha", "suvetha", "18-05"));
    }

    @GetMapping("/dynamic")
    public MappingJacksonValue dynamicFilterBean() {
        UserDynamicFilterBean userBean = new UserDynamicFilterBean("gautham", "gautham", "16-05");
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(userBean);
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("userName","birthDate");
        FilterProvider provider = new SimpleFilterProvider().addFilter("userBeanFilter", filter);
        mappingJacksonValue.setFilters(provider);
        return mappingJacksonValue;
    }

    @GetMapping("/dynamic-list")
    public MappingJacksonValue getDynamicFilteringList(){
        UserDynamicFilterBean userBean1 = new UserDynamicFilterBean("gautham", "gautham", "16-05");
        UserDynamicFilterBean userBean2 = new UserDynamicFilterBean("suvetha", "suvetha", "18-05");
        List<UserDynamicFilterBean> list = Arrays.asList(userBean1, userBean2);
        MappingJacksonValue jacksonValue = new MappingJacksonValue(list);
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("userName","birthDate");
        FilterProvider filters = new SimpleFilterProvider().addFilter("userBeanFilter", filter);
        jacksonValue.setFilters(filters);
        return jacksonValue;
    }
}
