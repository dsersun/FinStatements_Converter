package org.FinData;

import lombok.Getter;

@Getter
public class Resource {
    private final String url;
    private final String user;
    private final String pwd;

    {
        url = "jdbc:mysql://localhost:3306/finstatements";
        user = "java_app";
        pwd = "G>*>(hG@aaV6ds59@Txn";
    }


}
