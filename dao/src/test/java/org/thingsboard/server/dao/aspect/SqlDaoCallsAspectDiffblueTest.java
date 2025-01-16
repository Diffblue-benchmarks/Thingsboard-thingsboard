package org.thingsboard.server.dao.aspect;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.sql.SQLException;
import java.util.UUID;
import org.aspectj.lang.reflect.CodeSignature;
import org.aspectj.lang.reflect.MethodSignature;
import org.hibernate.exception.JDBCConnectionException;
import org.junit.Test;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.dao.model.ModelConstants;

public class SqlDaoCallsAspectDiffblueTest {
  /**
   * Test
   * {@link SqlDaoCallsAspect#getTenantId(MethodSignature, String, Object[])}.
   * <p>
   * Method under test:
   * {@link SqlDaoCallsAspect#getTenantId(MethodSignature, String, Object[])}
   */
  @Test
  public void testGetTenantId() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SqlDaoCallsAspect sqlDaoCallsAspect = new SqlDaoCallsAspect();
    MethodSignature signature = mock(MethodSignature.class);
    when(signature.getParameterTypes()).thenThrow(new JDBCConnectionException("tenantId", new SQLException()));

    // Act and Assert
    assertThrows(JDBCConnectionException.class,
        () -> sqlDaoCallsAspect.getTenantId(signature, "Method Name", new Object[]{"Args"}));
    verify(signature).getParameterTypes();
  }

  /**
   * Test
   * {@link SqlDaoCallsAspect#getTenantId(MethodSignature, String, Object[])}.
   * <p>
   * Method under test:
   * {@link SqlDaoCallsAspect#getTenantId(MethodSignature, String, Object[])}
   */
  @Test
  public void testGetTenantId2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SqlDaoCallsAspect sqlDaoCallsAspect = new SqlDaoCallsAspect();
    MethodSignature signature = mock(MethodSignature.class);
    when(signature.getParameterNames()).thenThrow(new JDBCConnectionException("tenantId", new SQLException()));

    // Act and Assert
    assertThrows(JDBCConnectionException.class,
        () -> sqlDaoCallsAspect.getTenantId(signature, "Method Name", new Object[]{ModelConstants.NULL_UUID}));
    verify(signature).getParameterNames();
  }

  /**
   * Test
   * {@link SqlDaoCallsAspect#getTenantId(MethodSignature, String, Object[])}.
   * <ul>
   *   <li>Given array of {@link String} with {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SqlDaoCallsAspect#getTenantId(MethodSignature, String, Object[])}
   */
  @Test
  public void testGetTenantId_givenArrayOfStringWithNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SqlDaoCallsAspect sqlDaoCallsAspect = new SqlDaoCallsAspect();
    MethodSignature signature = mock(MethodSignature.class);
    Class<Object> forNameResult = Object.class;
    when(signature.getParameterTypes()).thenReturn(new Class[]{forNameResult});
    when(signature.getParameterNames()).thenReturn(new String[]{null});

    // Act
    TenantId actualTenantId = sqlDaoCallsAspect.getTenantId(signature, "Method Name",
        new Object[]{ModelConstants.NULL_UUID});

    // Assert
    verify(signature, atLeast(1)).getParameterNames();
    verify(signature).getParameterTypes();
    assertNull(actualTenantId);
  }

  /**
   * Test
   * {@link SqlDaoCallsAspect#getTenantId(MethodSignature, String, Object[])}.
   * <ul>
   *   <li>Given array of {@link String} with {@code Parameter Names}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SqlDaoCallsAspect#getTenantId(MethodSignature, String, Object[])}
   */
  @Test
  public void testGetTenantId_givenArrayOfStringWithParameterNames() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SqlDaoCallsAspect sqlDaoCallsAspect = new SqlDaoCallsAspect();
    MethodSignature signature = mock(MethodSignature.class);
    Class<Object> forNameResult = Object.class;
    when(signature.getParameterTypes()).thenReturn(new Class[]{forNameResult});
    when(signature.getParameterNames()).thenReturn(new String[]{"Parameter Names"});

    // Act
    TenantId actualTenantId = sqlDaoCallsAspect.getTenantId(signature, "Method Name",
        new Object[]{ModelConstants.NULL_UUID});

    // Assert
    verify(signature, atLeast(1)).getParameterNames();
    verify(signature).getParameterTypes();
    assertNull(actualTenantId);
  }

  /**
   * Test
   * {@link SqlDaoCallsAspect#getTenantId(MethodSignature, String, Object[])}.
   * <ul>
   *   <li>Given array of {@link String} with {@code Parameter Names}.</li>
   *   <li>Then first element is {@code Args}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SqlDaoCallsAspect#getTenantId(MethodSignature, String, Object[])}
   */
  @Test
  public void testGetTenantId_givenArrayOfStringWithParameterNames_thenFirstElementIsArgs() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SqlDaoCallsAspect sqlDaoCallsAspect = new SqlDaoCallsAspect();
    MethodSignature signature = mock(MethodSignature.class);
    Class<Object> forNameResult = Object.class;
    when(signature.getParameterTypes()).thenReturn(new Class[]{forNameResult});
    when(signature.getParameterNames()).thenReturn(new String[]{"Parameter Names"});
    Object[] args = new Object[]{"Args"};

    // Act
    TenantId actualTenantId = sqlDaoCallsAspect.getTenantId(signature, "Method Name", args);

    // Assert
    verify(signature).getParameterNames();
    verify(signature).getParameterTypes();
    assertEquals("Args", args[0]);
    assertNull(actualTenantId);
    assertEquals(1, args.length);
  }

  /**
   * Test
   * {@link SqlDaoCallsAspect#getTenantId(MethodSignature, String, Object[])}.
   * <ul>
   *   <li>Given array of {@link String} with {@code tenantId}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SqlDaoCallsAspect#getTenantId(MethodSignature, String, Object[])}
   */
  @Test
  public void testGetTenantId_givenArrayOfStringWithTenantId() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SqlDaoCallsAspect sqlDaoCallsAspect = new SqlDaoCallsAspect();
    MethodSignature signature = mock(MethodSignature.class);
    Class<Object> forNameResult = Object.class;
    when(signature.getParameterTypes()).thenReturn(new Class[]{forNameResult});
    when(signature.getParameterNames()).thenReturn(new String[]{"tenantId"});
    Object[] args = new Object[]{"Args"};

    // Act
    TenantId actualTenantId = sqlDaoCallsAspect.getTenantId(signature, "Method Name", args);

    // Assert
    verify(signature).getParameterNames();
    verify(signature).getParameterTypes();
    assertEquals("Args", args[0]);
    assertNull(actualTenantId);
    assertEquals(1, args.length);
  }

  /**
   * Test
   * {@link SqlDaoCallsAspect#getTenantId(MethodSignature, String, Object[])}.
   * <ul>
   *   <li>Given array of {@link String} with {@code tenantId}.</li>
   *   <li>Then return {@link TenantId#SYS_TENANT_ID}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SqlDaoCallsAspect#getTenantId(MethodSignature, String, Object[])}
   */
  @Test
  public void testGetTenantId_givenArrayOfStringWithTenantId_thenReturnSys_tenant_id() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SqlDaoCallsAspect sqlDaoCallsAspect = new SqlDaoCallsAspect();
    MethodSignature signature = mock(MethodSignature.class);
    when(signature.getParameterNames()).thenReturn(new String[]{"tenantId"});

    // Act
    TenantId actualTenantId = sqlDaoCallsAspect.getTenantId(signature, "Method Name",
        new Object[]{ModelConstants.NULL_UUID});

    // Assert
    verify(signature, atLeast(1)).getParameterNames();
    assertSame(actualTenantId.SYS_TENANT_ID, actualTenantId);
  }

  /**
   * Test
   * {@link SqlDaoCallsAspect#getTenantId(MethodSignature, String, Object[])}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link MethodSignature} {@link CodeSignature#getParameterNames()}
   * return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SqlDaoCallsAspect#getTenantId(MethodSignature, String, Object[])}
   */
  @Test
  public void testGetTenantId_givenNull_whenMethodSignatureGetParameterNamesReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SqlDaoCallsAspect sqlDaoCallsAspect = new SqlDaoCallsAspect();
    MethodSignature signature = mock(MethodSignature.class);
    Class<Object> forNameResult = Object.class;
    when(signature.getParameterTypes()).thenReturn(new Class[]{forNameResult});
    when(signature.getParameterNames()).thenReturn(null);

    // Act
    TenantId actualTenantId = sqlDaoCallsAspect.getTenantId(signature, "Method Name",
        new Object[]{ModelConstants.NULL_UUID});

    // Assert
    verify(signature, atLeast(1)).getParameterNames();
    verify(signature).getParameterTypes();
    assertNull(actualTenantId);
  }

  /**
   * Test
   * {@link SqlDaoCallsAspect#getTenantId(MethodSignature, String, Object[])}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link MethodSignature} {@link CodeSignature#getParameterTypes()}
   * return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SqlDaoCallsAspect#getTenantId(MethodSignature, String, Object[])}
   */
  @Test
  public void testGetTenantId_givenNull_whenMethodSignatureGetParameterTypesReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SqlDaoCallsAspect sqlDaoCallsAspect = new SqlDaoCallsAspect();
    MethodSignature signature = mock(MethodSignature.class);
    when(signature.getParameterTypes()).thenReturn(null);
    when(signature.getParameterNames()).thenReturn(new String[]{"Parameter Names"});
    Object[] args = new Object[]{"Args"};

    // Act
    TenantId actualTenantId = sqlDaoCallsAspect.getTenantId(signature, "Method Name", args);

    // Assert
    verify(signature).getParameterNames();
    verify(signature).getParameterTypes();
    assertEquals("Args", args[0]);
    assertNull(actualTenantId);
    assertEquals(1, args.length);
  }

  /**
   * Test
   * {@link SqlDaoCallsAspect#getTenantId(MethodSignature, String, Object[])}.
   * <ul>
   *   <li>Given {@code org.thingsboard.server.common.data.id.TenantId}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SqlDaoCallsAspect#getTenantId(MethodSignature, String, Object[])}
   */
  @Test
  public void testGetTenantId_givenOrgThingsboardServerCommonDataIdTenantId() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SqlDaoCallsAspect sqlDaoCallsAspect = new SqlDaoCallsAspect();
    MethodSignature signature = mock(MethodSignature.class);
    Class<TenantId> forNameResult = TenantId.class;
    when(signature.getParameterTypes()).thenReturn(new Class[]{forNameResult});
    Object[] args = new Object[]{"Args"};

    // Act
    TenantId actualTenantId = sqlDaoCallsAspect.getTenantId(signature, "Method Name", args);

    // Assert
    verify(signature).getParameterTypes();
    assertEquals("Args", args[0]);
    assertNull(actualTenantId);
    assertEquals(1, args.length);
  }

  /**
   * Test
   * {@link SqlDaoCallsAspect#getTenantId(MethodSignature, String, Object[])}.
   * <ul>
   *   <li>Then first element is {@link TenantId#SYS_TENANT_ID}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SqlDaoCallsAspect#getTenantId(MethodSignature, String, Object[])}
   */
  @Test
  public void testGetTenantId_thenFirstElementIsSys_tenant_id() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    Object[] args = new Object[]{ModelConstants.SYSTEM_TENANT};

    // Act
    TenantId actualTenantId = (new SqlDaoCallsAspect()).getTenantId(mock(MethodSignature.class), "Method Name", args);

    // Assert
    assertEquals(1, args.length);
    TenantId tenantId = actualTenantId.SYS_TENANT_ID;
    assertSame(tenantId, actualTenantId);
    assertSame(tenantId, args[0]);
  }

  /**
   * Test
   * {@link SqlDaoCallsAspect#getTenantId(MethodSignature, String, Object[])}.
   * <ul>
   *   <li>When array of {@link Object} with randomUUID.</li>
   *   <li>Then return not NullUid.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SqlDaoCallsAspect#getTenantId(MethodSignature, String, Object[])}
   */
  @Test
  public void testGetTenantId_whenArrayOfObjectWithRandomUUID_thenReturnNotNullUid() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SqlDaoCallsAspect sqlDaoCallsAspect = new SqlDaoCallsAspect();
    MethodSignature signature = mock(MethodSignature.class);
    when(signature.getParameterNames()).thenReturn(new String[]{"tenantId"});
    UUID randomUUIDResult = UUID.randomUUID();

    // Act
    TenantId actualTenantId = sqlDaoCallsAspect.getTenantId(signature, "Method Name", new Object[]{randomUUIDResult});

    // Assert
    verify(signature, atLeast(1)).getParameterNames();
    assertFalse(actualTenantId.isNullUid());
    assertFalse(actualTenantId.isSysTenantId());
    assertSame(randomUUIDResult, actualTenantId.getId());
  }

  /**
   * Test
   * {@link SqlDaoCallsAspect#getTenantId(MethodSignature, String, Object[])}.
   * <ul>
   *   <li>When empty array of {@link Object}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SqlDaoCallsAspect#getTenantId(MethodSignature, String, Object[])}
   */
  @Test
  public void testGetTenantId_whenEmptyArrayOfObject_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new SqlDaoCallsAspect()).getTenantId(mock(MethodSignature.class), "Method Name", new Object[]{}));
  }

  /**
   * Test
   * {@link SqlDaoCallsAspect#getTenantId(MethodSignature, String, Object[])}.
   * <ul>
   *   <li>When {@link MethodSignature}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SqlDaoCallsAspect#getTenantId(MethodSignature, String, Object[])}
   */
  @Test
  public void testGetTenantId_whenMethodSignature_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertNull((new SqlDaoCallsAspect()).getTenantId(mock(MethodSignature.class), "Method Name", null));
  }
}
