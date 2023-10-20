/*
Prototype (Прототип)

Описание:
Помогает создать дублированный объект с лучшей производительностью,
вместо нового создается возвращаемый клон существующего объекта. Клонирует существующий объект.

В нашем примере в выводе мы создали два сложных объекта, которые представляют из себя клоны (копии)
объекта прототипа. По результатам вывода видим - что все три объекта - это разные объекты.

 */

package DesignPatterns.Prototype;

public class Main {
    public static void main(String[] args) {
        ComplicatedObject prototype = new ComplicatedObject();
        ComplicatedObject clone1 = prototype.copy();
        ComplicatedObject clone2 = prototype.copy();

        clone1.setType(ComplicatedObject.Type.ONE);
        clone2.setType(ComplicatedObject.Type.TWO);
        System.out.println(prototype);
        System.out.println(clone1);
        System.out.println(clone2);
    }
}