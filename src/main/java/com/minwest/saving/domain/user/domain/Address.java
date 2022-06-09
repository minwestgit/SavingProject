package com.minwest.saving.domain.user.domain;

import lombok.Getter;

import javax.persistence.Embeddable;

@Embeddable
@Getter
public class Address {

    private String zipcode;
    private String address;

    protected Address() {
    }

    public Address(String zipcode, String address) {
        this.zipcode = zipcode;
        this.address = address;
    }
}
