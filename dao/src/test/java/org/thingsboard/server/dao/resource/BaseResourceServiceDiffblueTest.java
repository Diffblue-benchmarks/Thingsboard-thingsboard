package org.thingsboard.server.dao.resource;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.dao.service.validator.ResourceDataValidator;
import org.thingsboard.server.dao.sql.resource.JpaTbResourceDao;
import org.thingsboard.server.dao.sql.resource.JpaTbResourceInfoDao;
import org.thingsboard.server.dao.sql.resource.TbResourceRepository;

public class BaseResourceServiceDiffblueTest {
  /**
   * Test {@link BaseResourceService#getEntityType()}.
   * <p>
   * Method under test: {@link BaseResourceService#getEntityType()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"EntityType BaseResourceService.getEntityType()"})
  public void testGetEntityType() {
    // Arrange
    JpaTbResourceDao resourceDao = new JpaTbResourceDao(mock(TbResourceRepository.class));
    JpaTbResourceInfoDao resourceInfoDao = new JpaTbResourceInfoDao();

    // Act and Assert
    assertEquals(EntityType.TB_RESOURCE,
        (new BaseResourceService(resourceDao, resourceInfoDao, new ResourceDataValidator())).getEntityType());
  }
}
