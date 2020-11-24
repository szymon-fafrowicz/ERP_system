package pl.fafrowicz.erpSystem.persistence.entity;

import lombok.Getter;
import lombok.Setter;
import pl.fafrowicz.erpSystem.web.dto.CompanyDto;
import pl.fafrowicz.erpSystem.web.dto.UserDto;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter

@Entity
@Table(name = "companies")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotBlank
    private String name;

    @OneToMany(mappedBy = "company")
    private List<User> users = new ArrayList<>();

    public CompanyDto castToDto() {
        CompanyDto companyDto = new CompanyDto();
        companyDto.setId(this.id);
        companyDto.setName(this.name);
        return companyDto;
    }

}