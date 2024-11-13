package org.thingsboard.server.utils;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.UnsupportedEncodingException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.TbResource;
import org.thingsboard.server.common.data.exception.ThingsboardException;
import org.thingsboard.server.common.data.lwm2m.LwM2mObject;
import org.thingsboard.server.dao.exception.DataValidationException;

class LwM2mObjectModelUtilsDiffblueTest {
  /**
   * Test {@link LwM2mObjectModelUtils#toLwm2mResource(TbResource)}.
   * <ul>
   *   <li>Given {@code foo.txt}.</li>
   *   <li>Then throw {@link DataValidationException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LwM2mObjectModelUtils#toLwm2mResource(TbResource)}
   */
  @Test
  @DisplayName("Test toLwm2mResource(TbResource); given 'foo.txt'; then throw DataValidationException")
  void testToLwm2mResource_givenFooTxt_thenThrowDataValidationException()
      throws UnsupportedEncodingException, ThingsboardException {
    // Arrange
    TbResource resource = mock(TbResource.class);
    when(resource.getFileName()).thenReturn("foo.txt");
    when(resource.getSearchText()).thenReturn("Search Text");
    when(resource.getData()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertThrows(DataValidationException.class, () -> LwM2mObjectModelUtils.toLwm2mResource(resource));
    verify(resource).getData();
    verify(resource, atLeast(1)).getFileName();
    verify(resource).getSearchText();
  }

  /**
   * Test {@link LwM2mObjectModelUtils#toLwM2mObject(TbResource, boolean)}.
   * <ul>
   *   <li>Given {@code Search Text}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link LwM2mObjectModelUtils#toLwM2mObject(TbResource, boolean)}
   */
  @Test
  @DisplayName("Test toLwM2mObject(TbResource, boolean); given 'Search Text'; then return 'null'")
  void testToLwM2mObject_givenSearchText_thenReturnNull() throws UnsupportedEncodingException {
    // Arrange
    TbResource resource = mock(TbResource.class);
    when(resource.getSearchText()).thenReturn("Search Text");
    when(resource.getData()).thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    LwM2mObject actualToLwM2mObjectResult = LwM2mObjectModelUtils.toLwM2mObject(resource, true);

    // Assert
    verify(resource).getData();
    verify(resource, atLeast(1)).getSearchText();
    assertNull(actualToLwM2mObjectResult);
  }
}
