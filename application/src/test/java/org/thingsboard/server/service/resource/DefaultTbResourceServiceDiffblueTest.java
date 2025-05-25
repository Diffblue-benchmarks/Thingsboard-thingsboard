package org.thingsboard.server.service.resource;

import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.thingsboard.server.common.data.ResourceType;
import org.thingsboard.server.common.data.TbResource;
import org.thingsboard.server.common.data.User;
import org.thingsboard.server.common.data.exception.ThingsboardException;

@ExtendWith(MockitoExtension.class)
class DefaultTbResourceServiceDiffblueTest {
  @InjectMocks
  private DefaultTbResourceService defaultTbResourceService;

  /**
   * Test {@link DefaultTbResourceService#save(TbResource, User)} with {@code TbResource}, {@code User}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTbResourceService#save(TbResource, User)}
   */
  @Test
  @DisplayName("Test save(TbResource, User) with 'TbResource', 'User'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbResource DefaultTbResourceService.save(TbResource, User)"})
  void testSaveWithTbResourceUser_thenThrowIllegalArgumentException() throws ThingsboardException {
    // Arrange
    TbResource resource = new TbResource();
    resource.setResourceType(ResourceType.IMAGE);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultTbResourceService.save(resource, new User()));
  }

  /**
   * Test {@link DefaultTbResourceService#delete(TbResource, User)} with {@code TbResource}, {@code User}.
   * <ul>
   *   <li>Given {@link ResourceType#IMAGE}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTbResourceService#delete(TbResource, User)}
   */
  @Test
  @DisplayName("Test delete(TbResource, User) with 'TbResource', 'User'; given IMAGE; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DefaultTbResourceService.delete(TbResource, User)"})
  void testDeleteWithTbResourceUser_givenImage_thenThrowIllegalArgumentException() {
    // Arrange
    TbResource tbResource = new TbResource();
    tbResource.setResourceType(ResourceType.IMAGE);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultTbResourceService.delete(tbResource, new User()));
  }
}
