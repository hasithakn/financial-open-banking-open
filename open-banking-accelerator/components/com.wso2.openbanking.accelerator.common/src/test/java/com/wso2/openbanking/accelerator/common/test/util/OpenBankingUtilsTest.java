/**
 * Copyright (c) 2023, WSO2 LLC. (https://www.wso2.com).
 *
 * WSO2 LLC. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package com.wso2.openbanking.accelerator.common.test.util;

import com.wso2.openbanking.accelerator.common.config.OpenBankingConfigParser;
import com.wso2.openbanking.accelerator.common.identity.IdentityConstants;
import com.wso2.openbanking.accelerator.common.util.OpenBankingUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mockito.Mock;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.testng.PowerMockTestCase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.text.ParseException;

import static org.mockito.Mockito.when;


/**
 * Test for Open Banking Utils.
 */
@PrepareForTest({OpenBankingConfigParser.class})
@PowerMockIgnore({"jdk.internal.reflect.*", "javax.management.*"})
public class OpenBankingUtilsTest extends PowerMockTestCase {

    private static final Log log = LogFactory.getLog(OpenBankingUtilsTest.class);
    @Mock
    OpenBankingConfigParser openBankingConfigParser;

    @BeforeMethod()
    public void before() {

        PowerMockito.mockStatic(OpenBankingConfigParser.class);
        openBankingConfigParser = PowerMockito.mock(OpenBankingConfigParser.class);
        PowerMockito.when(OpenBankingConfigParser.getInstance())
                .thenReturn(openBankingConfigParser);

    }

    @Test(priority = 1)
    public void getSoftwareEnvironmentFromSSA() throws ParseException {
        String sandboxSsa = "eyJ0eXAiOiJKV1QiLCJraWQiOiJoM1pDRjBWcnpnWGduSENxYkhiS1h6emZqVGciLCJhbGciOiJQUzI1NiJ9." +
                "eyJpYXQiOjE2OTg2ODQ4MjUsIm5iZiI6MTY5ODY4NDgyMSwiZXhwIjoxNjk4Njg4NDI2LCJqdGkiOiIyNDdlNjdmNjBmODA0YT" +
                "k5MTY5ODY4NDgyNSIsImlzcyI6Ik9wZW5CYW5raW5nIEx0ZCIsInNvZnR3YXJlX2Vudmlyb25tZW50Ijoic2FuZGJveCIsInNv" +
                "ZnR3YXJlX21vZGUiOiJUZXN0Iiwic29mdHdhcmVfaWQiOiIxMlp6RkZCeFNMR0VqUFpvZ1JBYnZGZHMxMTY5ODY4NDgyNSIsIn" +
                "NvZnR3YXJlX2NsaWVudF9pZCI6IjEwWnpGRkJ4U0xHRWpQWm9nUkFidkZkczEiLCJzb2Z0d2FyZV9jbGllbnRfbmFtZSI6IldT" +
                "TzIgT3BlbiBCYW5raW5nIFRQUCAoU2FuZGJveCkiLCJzb2Z0d2FyZV9jbGllbnRfZGVzY3JpcHRpb24iOiJXU08yIE9wZW4gQm" +
                "Fua2luZyBUUFAgZm9yIHRlc3RpbmciLCJzb2Z0d2FyZV92ZXJzaW9uIjoxLjUsInNvZnR3YXJlX2NsaWVudF91cmkiOiJodHRw" +
                "czovL3d3dy5nb29nbGUuY29tIiwic29mdHdhcmVfcmVkaXJlY3RfdXJpcyI6WyJodHRwczovL3d3dy5nb29nbGUuY29tL3JlZG" +
                "lyZWN0cy9yZWRpcmVjdDEiXSwic29mdHdhcmVfcm9sZXMiOlsiUElTUCIsIkFJU1AiLCJDQlBJSSJdLCJvcmdhbmlzYXRpb25f" +
                "Y29tcGV0ZW50X2F1dGhvcml0eV9jbGFpbXMiOnsiYXV0aG9yaXR5X2lkIjoiT0JHQlIiLCJyZWdpc3RyYXRpb25faWQiOiJVbm" +
                "tub3duMDAxNTgwMDAwMUhRUXJaQUFYIiwic3RhdHVzIjoiQWN0aXZlIiwiYXV0aG9yaXNhdGlvbnMiOlt7Im1lbWJlcl9zdGF0" +
                "ZSI6IkdCIiwicm9sZXMiOlsiUElTUCIsIkFJU1AiLCJDQlBJSSJdfSx7Im1lbWJlcl9zdGF0ZSI6IklFIiwicm9sZXMiOlsiUE" +
                "lTUCIsIkNCUElJIiwiQUlTUCJdfSx7Im1lbWJlcl9zdGF0ZSI6Ik5MIiwicm9sZXMiOlsiUElTUCIsIkFJU1AiLCJDQlBJSSJd" +
                "fV19LCJzb2Z0d2FyZV9sb2dvX3VyaSI6Imh0dHBzOi8vd3d3Lmdvb2dsZS5jb20iLCJvcmdfc3RhdHVzIjoiQWN0aXZlIiwib3" +
                "JnX2lkIjoiMDAxNTgwMDAwMUhRUXJaQUFYIiwib3JnX25hbWUiOiJXU08yIChVSykgTElNSVRFRCIsIm9yZ19jb250YWN0cyI6" +
                "W3sibmFtZSI6IlRlY2huaWNhbCIsImVtYWlsIjoic2FjaGluaXNAd3NvMi5jb20iLCJwaG9uZSI6Iis5NDc3NDI3NDM3NCIsIn" +
                "R5cGUiOiJUZWNobmljYWwifSx7Im5hbWUiOiJCdXNpbmVzcyIsImVtYWlsIjoic2FjaGluaXNAd3NvMi5jb20iLCJwaG9uZSI6" +
                "Iis5NDc3NDI3NDM3NCIsInR5cGUiOiJCdXNpbmVzcyJ9XSwib3JnX2p3a3NfZW5kcG9pbnQiOiJodHRwczovL2tleXN0b3JlLm" +
                "9wZW5iYW5raW5ndGVzdC5vcmcudWsvMDAxNTgwMDAwMUhRUXJaQUFYLzAwMTU4MDAwMDFIUVFyWkFBWC5qd2tzIiwib3JnX2p3" +
                "a3NfcmV2b2tlZF9lbmRwb2ludCI6Imh0dHBzOi8va2V5c3RvcmUub3BlbmJhbmtpbmd0ZXN0Lm9yZy51ay8wMDE1ODAwMDAxSF" +
                "FRclpBQVgvcmV2b2tlZC8wMDE1ODAwMDAxSFFRclpBQVguandrcyIsInNvZnR3YXJlX2p3a3NfZW5kcG9pbnQiOiJodHRwczov" +
                "L2tleXN0b3JlLm9wZW5iYW5raW5ndGVzdC5vcmcudWsvMDAxNTgwMDAwMUhRUXJaQUFYLzAwMTU4MDAwMDFIUVFyWkFBWC5qd2" +
                "tzIiwic29mdHdhcmVfandrc19yZXZva2VkX2VuZHBvaW50IjoiaHR0cHM6Ly9rZXlzdG9yZS5vcGVuYmFua2luZ3Rlc3Qub3Jn" +
                "LnVrLzAwMTU4MDAwMDFIUVFyWkFBWC9yZXZva2VkLzlaekZGQnhTTEdFalBab2dSQWJ2RmQuandrcyIsInNvZnR3YXJlX3BvbG" +
                "ljeV91cmkiOiJodHRwczovL3d3dy5nb29nbGUuY29tIiwic29mdHdhcmVfdG9zX3VyaSI6Imh0dHBzOi8vd3d3Lmdvb2dsZS5j" +
                "b20iLCJzb2Z0d2FyZV9vbl9iZWhhbGZfb2Zfb3JnIjpudWxsfQ.SUZaSo0sEfBU2ffN73IqNG8KAoYEO8vUIrZHBOxA-gF5dKN" +
                "IZR6pQ9cnuc3NzhmfHr9TAhiC_KVV9ULiwg0Kh0V79z57Ykjz6NuZ8m0tZPQbjOMQBrRXdnLkqqot_pO_2vwLCRFDfhWM2wqR4" +
                "lTXkM0KsdNSWgG3vl25JTkwqo1tTsYlZUcQFltlLQ-lCXT2nWnu_dPZWUqzVb9g4s2DcQ78xkJwqHJKgGLsloXzAMDx36MZQ01" +
                "fHP2eIFu82D0PgsxqvHbNeyXVlg5XsX5TLRwrRy8W4wP_SLMoP7jDic0yEufBRULROX2ckpoZuk31a_QyaJFKtIiPj9zlltM9Zg";
        PowerMockito.when(OpenBankingConfigParser.getInstance()
                        .getSoftwareEnvIdentificationSSAPropertyValueForSandbox()).thenReturn("sandbox");
        PowerMockito.when(OpenBankingConfigParser.getInstance()
                .getSoftwareEnvIdentificationSSAPropertyName()).thenReturn("software_environment");
        String softwareEnvironmentFromSSA = OpenBankingUtils.getSoftwareEnvironmentFromSSA(sandboxSsa);
        Assert.assertEquals(softwareEnvironmentFromSSA, IdentityConstants.SANDBOX);
    }

    @Test()
    public void getSoftwareEnvironmentFromSSAForProd() throws ParseException {
        String prodSsa = "eyJ0eXAiOiJKV1QiLCJraWQiOiJoM1pDRjBWcnpnWGduSENxYkhiS1h6emZqVGciLCJhbGciOiJQUzI1NiJ9." +
                "eyJpYXQiOjE2OTg2ODQ4MjUsIm5iZiI6MTY5ODY4NDgyMSwiZXhwIjoxNjk4Njg4NDI2LCJqdGkiOiIyNDdlNjdmNjBmODA0YT" +
                "k5MTY5ODY4NDgyNSIsImlzcyI6Ik9wZW5CYW5raW5nIEx0ZCIsInNvZnR3YXJlX2Vudmlyb25tZW50IjoicHJvZCIsInNvZnR3" +
                "YXJlX21vZGUiOiJUZXN0Iiwic29mdHdhcmVfaWQiOiIxMlp6RkZCeFNMR0VqUFpvZ1JBYnZGZHMxMTY5ODY4NDgyNSIsInNvZn" +
                "R3YXJlX2NsaWVudF9pZCI6IjEwWnpGRkJ4U0xHRWpQWm9nUkFidkZkczEiLCJzb2Z0d2FyZV9jbGllbnRfbmFtZSI6IldTTzIg" +
                "T3BlbiBCYW5raW5nIFRQUCAoU2FuZGJveCkiLCJzb2Z0d2FyZV9jbGllbnRfZGVzY3JpcHRpb24iOiJXU08yIE9wZW4gQmFua2" +
                "luZyBUUFAgZm9yIHRlc3RpbmciLCJzb2Z0d2FyZV92ZXJzaW9uIjoxLjUsInNvZnR3YXJlX2NsaWVudF91cmkiOiJodHRwczov" +
                "L3d3dy5nb29nbGUuY29tIiwic29mdHdhcmVfcmVkaXJlY3RfdXJpcyI6WyJodHRwczovL3d3dy5nb29nbGUuY29tL3JlZGlyZW" +
                "N0cy9yZWRpcmVjdDEiXSwic29mdHdhcmVfcm9sZXMiOlsiUElTUCIsIkFJU1AiLCJDQlBJSSJdLCJvcmdhbmlzYXRpb25fY29t" +
                "cGV0ZW50X2F1dGhvcml0eV9jbGFpbXMiOnsiYXV0aG9yaXR5X2lkIjoiT0JHQlIiLCJyZWdpc3RyYXRpb25faWQiOiJVbmtub3" +
                "duMDAxNTgwMDAwMUhRUXJaQUFYIiwic3RhdHVzIjoiQWN0aXZlIiwiYXV0aG9yaXNhdGlvbnMiOlt7Im1lbWJlcl9zdGF0ZSI6" +
                "IkdCIiwicm9sZXMiOlsiUElTUCIsIkFJU1AiLCJDQlBJSSJdfSx7Im1lbWJlcl9zdGF0ZSI6IklFIiwicm9sZXMiOlsiUElTUC" +
                "IsIkNCUElJIiwiQUlTUCJdfSx7Im1lbWJlcl9zdGF0ZSI6Ik5MIiwicm9sZXMiOlsiUElTUCIsIkFJU1AiLCJDQlBJSSJdfV19" +
                "LCJzb2Z0d2FyZV9sb2dvX3VyaSI6Imh0dHBzOi8vd3d3Lmdvb2dsZS5jb20iLCJvcmdfc3RhdHVzIjoiQWN0aXZlIiwib3JnX2" +
                "lkIjoiMDAxNTgwMDAwMUhRUXJaQUFYIiwib3JnX25hbWUiOiJXU08yIChVSykgTElNSVRFRCIsIm9yZ19jb250YWN0cyI6W3si" +
                "bmFtZSI6IlRlY2huaWNhbCIsImVtYWlsIjoic2FjaGluaXNAd3NvMi5jb20iLCJwaG9uZSI6Iis5NDc3NDI3NDM3NCIsInR5cG" +
                "UiOiJUZWNobmljYWwifSx7Im5hbWUiOiJCdXNpbmVzcyIsImVtYWlsIjoic2FjaGluaXNAd3NvMi5jb20iLCJwaG9uZSI6Iis5" +
                "NDc3NDI3NDM3NCIsInR5cGUiOiJCdXNpbmVzcyJ9XSwib3JnX2p3a3NfZW5kcG9pbnQiOiJodHRwczovL2tleXN0b3JlLm9wZW" +
                "5iYW5raW5ndGVzdC5vcmcudWsvMDAxNTgwMDAwMUhRUXJaQUFYLzAwMTU4MDAwMDFIUVFyWkFBWC5qd2tzIiwib3JnX2p3a3Nf" +
                "cmV2b2tlZF9lbmRwb2ludCI6Imh0dHBzOi8va2V5c3RvcmUub3BlbmJhbmtpbmd0ZXN0Lm9yZy51ay8wMDE1ODAwMDAxSFFRcl" +
                "pBQVgvcmV2b2tlZC8wMDE1ODAwMDAxSFFRclpBQVguandrcyIsInNvZnR3YXJlX2p3a3NfZW5kcG9pbnQiOiJodHRwczovL2tl" +
                "eXN0b3JlLm9wZW5iYW5raW5ndGVzdC5vcmcudWsvMDAxNTgwMDAwMUhRUXJaQUFYLzAwMTU4MDAwMDFIUVFyWkFBWC5qd2tzIi" +
                "wic29mdHdhcmVfandrc19yZXZva2VkX2VuZHBvaW50IjoiaHR0cHM6Ly9rZXlzdG9yZS5vcGVuYmFua2luZ3Rlc3Qub3JnLnVr" +
                "LzAwMTU4MDAwMDFIUVFyWkFBWC9yZXZva2VkLzlaekZGQnhTTEdFalBab2dSQWJ2RmQuandrcyIsInNvZnR3YXJlX3BvbGljeV" +
                "91cmkiOiJodHRwczovL3d3dy5nb29nbGUuY29tIiwic29mdHdhcmVfdG9zX3VyaSI6Imh0dHBzOi8vd3d3Lmdvb2dsZS5jb20i" +
                "LCJzb2Z0d2FyZV9vbl9iZWhhbGZfb2Zfb3JnIjpudWxsfQ.NLglx-H9D-i2f9GmSrxq00wTlKGHW_6zmKxGg_UhX0P0dzqJmNW" +
                "UCDBdz-HhjlPSGeLqumyM_hJZELGv96p6CllmHdNA12gIGem3oBqnaPq9wfcr5Esn7sfRODPComjr6lKxNSXraLT7qpRHCJoxq" +
                "yi72RH7T6HyF5lobTHWcZRkCNtc9cWJMKbftGCDSGRlO0XSYvvdGMDBCQT5-KiuKiWcKcBcFX2TLpTDDYaf-GNtATQ0O_vl266" +
                "fDPyzG9XF6NLheG0ITrTBGuVN2JzSDC50_vCqR754LtFKNLXKQ2WTnrY3TgEBbyaKj3N0_YdDIuT442zkadg8lvoNpXyk4A";

        PowerMockito.when(OpenBankingConfigParser.getInstance()
                        .getSoftwareEnvIdentificationSSAPropertyValueForSandbox()).thenReturn("sandbox");
        PowerMockito.when(OpenBankingConfigParser.getInstance()
                .getSoftwareEnvIdentificationSSAPropertyName()).thenReturn("software_environment");
        String softwareEnvironmentFromSSA = OpenBankingUtils.getSoftwareEnvironmentFromSSA(prodSsa);
        Assert.assertEquals(softwareEnvironmentFromSSA, IdentityConstants.PRODUCTION);
    }

    @Test
    public void testDisputeDataWhenNonErrorPublishingEnabled() throws Exception {

        when(openBankingConfigParser.isNonErrorDisputeDataPublishingEnabled()).thenReturn(true);

        Assert.assertTrue(OpenBankingUtils.isPublishableDisputeData(400));
        Assert.assertTrue(OpenBankingUtils.isPublishableDisputeData(200));
    }

    @Test
    public void testDisputeDataWhenNonErrorPublishingDisabled() throws Exception {

        when(openBankingConfigParser.isNonErrorDisputeDataPublishingEnabled()).thenReturn(false);

        Assert.assertTrue(OpenBankingUtils.isPublishableDisputeData(400));
        Assert.assertFalse(OpenBankingUtils.isPublishableDisputeData(200));
    }

    @Test
    public void testReducingStringLength() throws Exception {

        String body = "String Body";
        Assert.assertEquals(OpenBankingUtils.reduceStringLength(body, 25), body);
        Assert.assertEquals(OpenBankingUtils.reduceStringLength(body, 6), "String");
    }
}
