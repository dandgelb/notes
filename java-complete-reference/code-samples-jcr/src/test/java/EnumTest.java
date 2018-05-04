import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.is;

enum Role {
    Admin, Anonymous, Author, Publisher
}

enum AnotherRole {
    Admin(1), Anonymous, Author(5), Publisher(6);

    private int roleId;

    AnotherRole() {
        roleId = 0;
    }

    AnotherRole(int r) {
        roleId = r;
    }
    int getRoleId() {
        return roleId;
    }
}

interface Abbreviation {
    public Character getRoleAbbreviation();
}

enum RoleAbbreviation implements Abbreviation{
    Admin('A'), Anonymous('G'), Author('W'), Publisher('P');
    private Character roleAbbreviation;
    RoleAbbreviation(Character s) {
        roleAbbreviation = s;
    }
    public Character getRoleAbbreviation() {
        return roleAbbreviation;
    }
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

        Role [] allRoles = Role.values();
        Arrays.stream(allRoles)
                .forEach(System.out::println);
    }

    @Test
    public void testAnotherRole() {
        Assert.assertEquals(1, AnotherRole.Admin.getRoleId());
        Stream.of(AnotherRole.values())
                .filter((r) -> r.getRoleId() != 0)
                .forEach((r) -> System.out.println(r + ": " + r.getRoleId()));

        Assert.assertThat(AnotherRole.Anonymous.getRoleId(), is(0));
    }

    @Test
    public void testRoleAbbreviation() {
        Assert.assertThat(RoleAbbreviation.Admin.getRoleAbbreviation(), is('A'));
    }
}
