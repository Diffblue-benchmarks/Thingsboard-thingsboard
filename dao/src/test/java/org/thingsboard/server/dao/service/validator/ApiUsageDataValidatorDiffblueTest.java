package org.thingsboard.server.dao.service.validator;

import static org.junit.Assert.assertThrows;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.thingsboard.server.common.data.ApiUsageState;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.dao.exception.DataValidationException;
import org.thingsboard.server.dao.model.ModelConstants;

@ContextConfiguration(classes = {ApiUsageDataValidator.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class ApiUsageDataValidatorDiffblueTest {
  @Autowired private ApiUsageDataValidator apiUsageDataValidator;

  /**
   * Test {@link ApiUsageDataValidator#validateDataImpl(TenantId, ApiUsageState)} with {@code
   * TenantId}, {@code ApiUsageState}.
   *
   * <ul>
   *   <li>When {@link ApiUsageState#ApiUsageState()}.
   * </ul>
   *
   * <p>Method under test: {@link ApiUsageDataValidator#validateDataImpl(TenantId, ApiUsageState)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ApiUsageDataValidator.validateDataImpl(TenantId, ApiUsageState)"})
  public void testValidateDataImplWithTenantIdApiUsageState_whenApiUsageState() {
    // Arrange, Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            apiUsageDataValidator.validateDataImpl(
                ModelConstants.SYSTEM_TENANT, new ApiUsageState()));
  }
}
