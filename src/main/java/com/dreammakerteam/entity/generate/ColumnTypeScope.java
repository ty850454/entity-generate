package com.dreammakerteam.entity.generate;


import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.StringJoiner;

@Getter
@Setter
public class ColumnTypeScope implements Serializable {
    private static final long serialVersionUID = 2586046853264011990L;
    private Integer scope;
    private Integer secondScope;

    @Override
    public String toString() {
        StringJoiner sj = new StringJoiner(",", "(", ")");
        sj.add(scope.toString());
        if (secondScope != null) {
            sj.add(secondScope.toString());
        }
        return sj.toString();
    }
}
