    package com.accounting.accountingapp.entity;

    import com.accounting.accountingapp.enums.CompanyStatus;
    import lombok.Getter;
    import lombok.NoArgsConstructor;
    import lombok.Setter;
    import lombok.ToString;

    import javax.persistence.*;

    @Entity
    @NoArgsConstructor
    @Getter
    @Setter
    @ToString
    @Table(name = "companies")
    public class Company extends BaseEntity {
        @Column(unique = true)
        private String title;
        private String phone;
        private String website;

        @Enumerated(EnumType.STRING)
        private CompanyStatus companyStatus;

        @OneToOne(fetch = FetchType.LAZY)
        private Address address;
    }
