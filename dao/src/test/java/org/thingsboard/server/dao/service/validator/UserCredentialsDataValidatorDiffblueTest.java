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
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.security.UserCredentials;
import org.thingsboard.server.dao.exception.DataValidationException;
import org.thingsboard.server.dao.exception.IncorrectParameterException;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.user.UserCredentialsDao;

@ContextConfiguration(classes = {UserCredentialsDataValidator.class})
@DisabledInAotMode
@RunWith(SpringJUnit4ClassRunner.class)
public class UserCredentialsDataValidatorDiffblueTest {
  @MockBean
  private UserCredentialsDao userCredentialsDao;

  @Autowired
  private UserCredentialsDataValidator userCredentialsDataValidator;

  /**
   * Test {@link UserCredentialsDataValidator#validateCreate(TenantId, UserCredentials)} with {@code TenantId}, {@code UserCredentials}.
   * <p>
   * Method under test: {@link UserCredentialsDataValidator#validateCreate(TenantId, UserCredentials)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void UserCredentialsDataValidator.validateCreate(TenantId, UserCredentials)"})
  public void testValidateCreateWithTenantIdUserCredentials() {
    // Arrange, Act and Assert
    assertThrows(IncorrectParameterException.class,
        () -> userCredentialsDataValidator.validateCreate(ModelConstants.SYSTEM_TENANT, new UserCredentials()));
  }

  /**
   * Test {@link UserCredentialsDataValidator#validateDataImpl(TenantId, UserCredentials)} with {@code TenantId}, {@code UserCredentials}.
   * <ul>
   *   <li>When {@link UserCredentials#UserCredentials()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UserCredentialsDataValidator#validateDataImpl(TenantId, UserCredentials)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void UserCredentialsDataValidator.validateDataImpl(TenantId, UserCredentials)"})
  public void testValidateDataImplWithTenantIdUserCredentials_whenUserCredentials() {
    // Arrange, Act and Assert
    assertThrows(DataValidationException.class,
        () -> userCredentialsDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, new UserCredentials()));
  }
}
