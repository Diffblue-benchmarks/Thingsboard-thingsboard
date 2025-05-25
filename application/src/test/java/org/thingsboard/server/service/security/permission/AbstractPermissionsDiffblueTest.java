package org.thingsboard.server.service.security.permission;

import static org.junit.jupiter.api.Assertions.assertFalse;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {CustomerUserPermissions.class})
@ExtendWith(SpringExtension.class)
class AbstractPermissionsDiffblueTest {
  @Autowired
  private AbstractPermissions abstractPermissions;

  /**
   * Test {@link AbstractPermissions#getPermissionChecker(Resource)}.
   * <p>
   * Method under test: {@link AbstractPermissions#getPermissionChecker(Resource)}
   */
  @Test
  @DisplayName("Test getPermissionChecker(Resource)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.Optional AbstractPermissions.getPermissionChecker(Resource)"})
  void testGetPermissionChecker() {
    // Arrange, Act and Assert
    assertFalse(abstractPermissions.getPermissionChecker(Resource.ADMIN_SETTINGS).isPresent());
  }
}
