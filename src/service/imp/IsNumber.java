package service.imp;

import service.CheckSafeNumber;

/**
 * Created by zhouhuanping$ on 2024/6/22$.
 */
public class IsNumber implements CheckSafeNumber {

    @Override
    public boolean isOk(String line) {
        try {
            Integer.parseInt(line);

        }catch (Exception e){
            return false;
        }

        return true;
    }

    @Override
    public boolean rightLength(String line) {
        return line.length() <= 12 && line.length() >= 6;

    }
}
