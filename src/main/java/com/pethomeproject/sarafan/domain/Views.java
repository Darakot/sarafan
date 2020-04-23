package com.pethomeproject.sarafan.domain;

/**
 * Класс для отображение нужных полей у других сущностей
 */

public final class Views {

    public interface Id {}

    public interface IdName  extends Id{}

    public interface FullComment extends IdName {}

    public interface FullMessage extends IdName {}

    public interface FullProfile extends IdName {}
}
