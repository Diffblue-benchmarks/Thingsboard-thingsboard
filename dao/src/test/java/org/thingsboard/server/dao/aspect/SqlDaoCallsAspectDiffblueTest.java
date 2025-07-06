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
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.sql.SQLException;
import java.util.UUID;
import org.aspectj.lang.reflect.MethodSignature;
import org.hibernate.exception.JDBCConnectionException;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.dao.model.ModelConstants;

public class SqlDaoCallsAspectDiffblueTest {
  /**
   * Test {@link SqlDaoCallsAspect#getTenantId(MethodSignature, String, Object[])}.
   *
   * <ul>
   *   <li>Given array of {@link String} with {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SqlDaoCallsAspect#getTenantId(MethodSignature, String, Object[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TenantId SqlDaoCallsAspect.getTenantId(MethodSignature, String, Object[])"})
  public void testGetTenantId_givenArrayOfStringWithNull() {
    // Arrange
    SqlDaoCallsAspect sqlDaoCallsAspect = new SqlDaoCallsAspect();
    MethodSignature signature = mock(MethodSignature.class);
    Class<Object> forNameResult = Object.class;
    when(signature.getParameterTypes()).thenReturn(new Class[] {forNameResult});
    when(signature.getParameterNames()).thenReturn(new String[] {null});
    UUID fromStringResult = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    Object[] args = new Object[] {fromStringResult};

    // Act
    TenantId actualTenantId = sqlDaoCallsAspect.getTenantId(signature, "Method Name", args);

    // Assert
    verify(signature, atLeast(1)).getParameterNames();
    verify(signature).getParameterTypes();
    assertNull(actualTenantId);
    assertEquals(1, args.length);
    assertSame(fromStringResult, args[0]);
  }

  /**
   * Test {@link SqlDaoCallsAspect#getTenantId(MethodSignature, String, Object[])}.
   *
   * <ul>
   *   <li>Given array of {@link String} with {@code Parameter Names}.
   *   <li>Then first element is {@code Args}.
   * </ul>
   *
   * <p>Method under test: {@link SqlDaoCallsAspect#getTenantId(MethodSignature, String, Object[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TenantId SqlDaoCallsAspect.getTenantId(MethodSignature, String, Object[])"})
  public void testGetTenantId_givenArrayOfStringWithParameterNames_thenFirstElementIsArgs() {
    // Arrange
    SqlDaoCallsAspect sqlDaoCallsAspect = new SqlDaoCallsAspect();
    MethodSignature signature = mock(MethodSignature.class);
    Class<Object> forNameResult = Object.class;
    when(signature.getParameterTypes()).thenReturn(new Class[] {forNameResult});
    when(signature.getParameterNames()).thenReturn(new String[] {"Parameter Names"});
    Object[] args = new Object[] {"Args"};

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
   * Test {@link SqlDaoCallsAspect#getTenantId(MethodSignature, String, Object[])}.
   *
   * <ul>
   *   <li>Given array of {@link String} with {@code tenantId}.
   * </ul>
   *
   * <p>Method under test: {@link SqlDaoCallsAspect#getTenantId(MethodSignature, String, Object[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TenantId SqlDaoCallsAspect.getTenantId(MethodSignature, String, Object[])"})
  public void testGetTenantId_givenArrayOfStringWithTenantId() {
    // Arrange
    SqlDaoCallsAspect sqlDaoCallsAspect = new SqlDaoCallsAspect();
    MethodSignature signature = mock(MethodSignature.class);
    Class<Object> forNameResult = Object.class;
    when(signature.getParameterTypes()).thenReturn(new Class[] {forNameResult});
    when(signature.getParameterNames()).thenReturn(new String[] {"tenantId"});
    Object[] args = new Object[] {"Args"};

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
   * Test {@link SqlDaoCallsAspect#getTenantId(MethodSignature, String, Object[])}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link MethodSignature} {@link MethodSignature#getParameterNames()} return {@code
   *       null}.
   * </ul>
   *
   * <p>Method under test: {@link SqlDaoCallsAspect#getTenantId(MethodSignature, String, Object[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TenantId SqlDaoCallsAspect.getTenantId(MethodSignature, String, Object[])"})
  public void testGetTenantId_givenNull_whenMethodSignatureGetParameterNamesReturnNull() {
    // Arrange
    SqlDaoCallsAspect sqlDaoCallsAspect = new SqlDaoCallsAspect();
    MethodSignature signature = mock(MethodSignature.class);
    Class<Object> forNameResult = Object.class;
    when(signature.getParameterTypes()).thenReturn(new Class[] {forNameResult});
    when(signature.getParameterNames()).thenReturn(null);
    UUID fromStringResult = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    Object[] args = new Object[] {fromStringResult};

    // Act
    TenantId actualTenantId = sqlDaoCallsAspect.getTenantId(signature, "Method Name", args);

    // Assert
    verify(signature, atLeast(1)).getParameterNames();
    verify(signature).getParameterTypes();
    assertNull(actualTenantId);
    assertEquals(1, args.length);
    assertSame(fromStringResult, args[0]);
  }

  /**
   * Test {@link SqlDaoCallsAspect#getTenantId(MethodSignature, String, Object[])}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link MethodSignature} {@link MethodSignature#getParameterTypes()} return {@code
   *       null}.
   * </ul>
   *
   * <p>Method under test: {@link SqlDaoCallsAspect#getTenantId(MethodSignature, String, Object[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TenantId SqlDaoCallsAspect.getTenantId(MethodSignature, String, Object[])"})
  public void testGetTenantId_givenNull_whenMethodSignatureGetParameterTypesReturnNull() {
    // Arrange
    SqlDaoCallsAspect sqlDaoCallsAspect = new SqlDaoCallsAspect();
    MethodSignature signature = mock(MethodSignature.class);
    when(signature.getParameterTypes()).thenReturn(null);
    when(signature.getParameterNames()).thenReturn(new String[] {"Parameter Names"});
    Object[] args = new Object[] {"Args"};

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
   * Test {@link SqlDaoCallsAspect#getTenantId(MethodSignature, String, Object[])}.
   *
   * <ul>
   *   <li>Given {@code TenantId}.
   * </ul>
   *
   * <p>Method under test: {@link SqlDaoCallsAspect#getTenantId(MethodSignature, String, Object[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TenantId SqlDaoCallsAspect.getTenantId(MethodSignature, String, Object[])"})
  public void testGetTenantId_givenOrgThingsboardServerCommonDataIdTenantId() {
    // Arrange
    SqlDaoCallsAspect sqlDaoCallsAspect = new SqlDaoCallsAspect();
    MethodSignature signature = mock(MethodSignature.class);
    Class<TenantId> forNameResult = TenantId.class;
    when(signature.getParameterTypes()).thenReturn(new Class[] {forNameResult});
    Object[] args = new Object[] {"Args"};

    // Act
    TenantId actualTenantId = sqlDaoCallsAspect.getTenantId(signature, "Method Name", args);

    // Assert
    verify(signature).getParameterTypes();
    assertEquals("Args", args[0]);
    assertNull(actualTenantId);
    assertEquals(1, args.length);
  }

  /**
   * Test {@link SqlDaoCallsAspect#getTenantId(MethodSignature, String, Object[])}.
   *
   * <ul>
   *   <li>Then first element is fromString {@code 784f394c-42b6-435a-983c-b7beff2784f9}.
   * </ul>
   *
   * <p>Method under test: {@link SqlDaoCallsAspect#getTenantId(MethodSignature, String, Object[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TenantId SqlDaoCallsAspect.getTenantId(MethodSignature, String, Object[])"})
  public void testGetTenantId_thenFirstElementIsFromString784f394c42b6435a983cB7beff2784f9() {
    // Arrange
    SqlDaoCallsAspect sqlDaoCallsAspect = new SqlDaoCallsAspect();
    MethodSignature signature = mock(MethodSignature.class);
    Class<Object> forNameResult = Object.class;
    when(signature.getParameterTypes()).thenReturn(new Class[] {forNameResult});
    when(signature.getParameterNames()).thenReturn(new String[] {"Parameter Names"});
    UUID fromStringResult = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    Object[] args = new Object[] {fromStringResult};

    // Act
    TenantId actualTenantId = sqlDaoCallsAspect.getTenantId(signature, "Method Name", args);

    // Assert
    verify(signature, atLeast(1)).getParameterNames();
    verify(signature).getParameterTypes();
    assertNull(actualTenantId);
    assertEquals(1, args.length);
    assertSame(fromStringResult, args[0]);
  }

  /**
   * Test {@link SqlDaoCallsAspect#getTenantId(MethodSignature, String, Object[])}.
   *
   * <ul>
   *   <li>Then return Id toString is {@code 784f394c-42b6-435a-983c-b7beff2784f9}.
   * </ul>
   *
   * <p>Method under test: {@link SqlDaoCallsAspect#getTenantId(MethodSignature, String, Object[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TenantId SqlDaoCallsAspect.getTenantId(MethodSignature, String, Object[])"})
  public void testGetTenantId_thenReturnIdToStringIs784f394c42b6435a983cB7beff2784f9() {
    // Arrange
    SqlDaoCallsAspect sqlDaoCallsAspect = new SqlDaoCallsAspect();
    MethodSignature signature = mock(MethodSignature.class);
    when(signature.getParameterNames()).thenReturn(new String[] {"tenantId"});

    // Act
    TenantId actualTenantId =
        sqlDaoCallsAspect.getTenantId(
            signature,
            "Method Name",
            new Object[] {UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")});

    // Assert
    verify(signature, atLeast(1)).getParameterNames();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", actualTenantId.getId().toString());
    assertEquals(EntityType.TENANT, actualTenantId.getEntityType());
    assertFalse(actualTenantId.isNullUid());
    assertFalse(actualTenantId.isSysTenantId());
  }

  /**
   * Test {@link SqlDaoCallsAspect#getTenantId(MethodSignature, String, Object[])}.
   *
   * <ul>
   *   <li>Then throw {@link JDBCConnectionException}.
   * </ul>
   *
   * <p>Method under test: {@link SqlDaoCallsAspect#getTenantId(MethodSignature, String, Object[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TenantId SqlDaoCallsAspect.getTenantId(MethodSignature, String, Object[])"})
  public void testGetTenantId_thenThrowJDBCConnectionException() {
    // Arrange
    SqlDaoCallsAspect sqlDaoCallsAspect = new SqlDaoCallsAspect();
    MethodSignature signature = mock(MethodSignature.class);
    when(signature.getParameterTypes())
        .thenThrow(new JDBCConnectionException("tenantId", new SQLException()));

    // Act and Assert
    assertThrows(
        JDBCConnectionException.class,
        () -> sqlDaoCallsAspect.getTenantId(signature, "Method Name", new Object[] {"Args"}));
    verify(signature).getParameterTypes();
  }

  /**
   * Test {@link SqlDaoCallsAspect#getTenantId(MethodSignature, String, Object[])}.
   *
   * <ul>
   *   <li>Then throw {@link JDBCConnectionException}.
   * </ul>
   *
   * <p>Method under test: {@link SqlDaoCallsAspect#getTenantId(MethodSignature, String, Object[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TenantId SqlDaoCallsAspect.getTenantId(MethodSignature, String, Object[])"})
  public void testGetTenantId_thenThrowJDBCConnectionException2() {
    // Arrange
    SqlDaoCallsAspect sqlDaoCallsAspect = new SqlDaoCallsAspect();
    MethodSignature signature = mock(MethodSignature.class);
    when(signature.getParameterNames())
        .thenThrow(new JDBCConnectionException("tenantId", new SQLException()));

    // Act and Assert
    assertThrows(
        JDBCConnectionException.class,
        () ->
            sqlDaoCallsAspect.getTenantId(
                signature,
                "Method Name",
                new Object[] {UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")}));
    verify(signature).getParameterNames();
  }

  /**
   * Test {@link SqlDaoCallsAspect#getTenantId(MethodSignature, String, Object[])}.
   *
   * <ul>
   *   <li>When array of {@link Object} with randomUUID.
   *   <li>Then return Id is randomUUID.
   * </ul>
   *
   * <p>Method under test: {@link SqlDaoCallsAspect#getTenantId(MethodSignature, String, Object[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TenantId SqlDaoCallsAspect.getTenantId(MethodSignature, String, Object[])"})
  public void testGetTenantId_whenArrayOfObjectWithRandomUUID_thenReturnIdIsRandomUUID() {
    // Arrange
    SqlDaoCallsAspect sqlDaoCallsAspect = new SqlDaoCallsAspect();
    MethodSignature signature = mock(MethodSignature.class);
    when(signature.getParameterNames()).thenReturn(new String[] {"tenantId"});
    UUID randomUUIDResult = UUID.randomUUID();

    // Act
    TenantId actualTenantId =
        sqlDaoCallsAspect.getTenantId(signature, "Method Name", new Object[] {randomUUIDResult});

    // Assert
    verify(signature, atLeast(1)).getParameterNames();
    assertEquals(EntityType.TENANT, actualTenantId.getEntityType());
    assertFalse(actualTenantId.isNullUid());
    assertFalse(actualTenantId.isSysTenantId());
    assertSame(randomUUIDResult, actualTenantId.getId());
  }

  /**
   * Test {@link SqlDaoCallsAspect#getTenantId(MethodSignature, String, Object[])}.
   *
   * <ul>
   *   <li>When array of {@link Object} with {@link ModelConstants#SYSTEM_TENANT}.
   *   <li>Then return {@link TenantId#SYS_TENANT_ID}.
   * </ul>
   *
   * <p>Method under test: {@link SqlDaoCallsAspect#getTenantId(MethodSignature, String, Object[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TenantId SqlDaoCallsAspect.getTenantId(MethodSignature, String, Object[])"})
  public void testGetTenantId_whenArrayOfObjectWithSystem_tenant_thenReturnSys_tenant_id() {
    // Arrange
    Object[] args = new Object[] {ModelConstants.SYSTEM_TENANT};

    // Act
    TenantId actualTenantId =
        new SqlDaoCallsAspect().getTenantId(mock(MethodSignature.class), "Method Name", args);

    // Assert
    assertEquals(1, args.length);
    TenantId tenantId = actualTenantId.SYS_TENANT_ID;
    assertSame(tenantId, actualTenantId);
    assertSame(tenantId, args[0]);
  }

  /**
   * Test {@link SqlDaoCallsAspect#getTenantId(MethodSignature, String, Object[])}.
   *
   * <ul>
   *   <li>When empty array of {@link Object}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SqlDaoCallsAspect#getTenantId(MethodSignature, String, Object[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TenantId SqlDaoCallsAspect.getTenantId(MethodSignature, String, Object[])"})
  public void testGetTenantId_whenEmptyArrayOfObject_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(
        new SqlDaoCallsAspect()
            .getTenantId(mock(MethodSignature.class), "Method Name", new Object[] {}));
  }

  /**
   * Test {@link SqlDaoCallsAspect#getTenantId(MethodSignature, String, Object[])}.
   *
   * <ul>
   *   <li>When {@link MethodSignature}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SqlDaoCallsAspect#getTenantId(MethodSignature, String, Object[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TenantId SqlDaoCallsAspect.getTenantId(MethodSignature, String, Object[])"})
  public void testGetTenantId_whenMethodSignature_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(
        new SqlDaoCallsAspect().getTenantId(mock(MethodSignature.class), "Method Name", null));
  }
}
