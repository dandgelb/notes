import org.junit.Assert;
import org.junit.Test;

import java.util.stream.Stream;

enum Role {
    Admin, Anonymous, Author, Publisher
}

class RoleEnumWrapper {

    public String getRole(Role role) {
        String r;
        switch (role) {
            case Admin:
                r = "Admin";
                break;
            case Anonymous:
                r = "Anonymous";
                break;
            case Author:
                r = "Author";
                break;
            case Publisher:
                r = "Publisher";
                break;
            default:
                r = "Invalid";
        }
        return r;
    }
}
public class EnumTest {
    @Test
    public void noTest() {
        Assert.assertEquals(true, true);
    }

    @Test
    public void testEnum() {
        Role role;
        role = Role.Admin;
        Assert.assertEquals(Role.Admin, role);
        RoleEnumWrapper rw = new RoleEnumWrapper();
        Assert.assertEquals("Admin", rw.getRole(role));
        role = Role.Anonymous;
        Assert.assertEquals("Anonymous", rw.getRole(role));
        Assert.assertEquals(Role.Anonymous, Role.valueOf("Anonymous"));
    }

    @Test
    public void testEnumPredefinedMethods() {
        Stream.of(Role.values())
                .forEach(System.out::println);
        Assert.assertEquals(Role.Publisher, Role.valueOf("Publisher"));
    }
}
