package org.thingsboard.server.dao.service.validator;

import static org.junit.Assert.assertThrows;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.thingsboard.server.common.data.User;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.dao.customer.CustomerDao;
import org.thingsboard.server.dao.exception.DataValidationException;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.user.UserDao;

@ContextConfiguration(classes = {UserDataValidator.class})
@DisabledInAotMode
@RunWith(SpringJUnit4ClassRunner.class)
public class UserDataValidatorDiffblueTest {
  @MockBean
  private CustomerDao customerDao;

  @MockBean
  private UserDao userDao;

  @Autowired
  private UserDataValidator userDataValidator;

  /**
   * Test {@link UserDataValidator#validateDataImpl(TenantId, User)} with {@code TenantId}, {@code User}.
   * <ul>
   *   <li>When {@link User#User()}.</li>
   *   <li>Then throw {@link DataValidationException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UserDataValidator#validateDataImpl(TenantId, User)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void UserDataValidator.validateDataImpl(TenantId, User)"})
  public void testValidateDataImplWithTenantIdUser_whenUser_thenThrowDataValidationException() {
    // Arrange, Act and Assert
    assertThrows(DataValidationException.class,
        () -> userDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, new User()));
  }
}
