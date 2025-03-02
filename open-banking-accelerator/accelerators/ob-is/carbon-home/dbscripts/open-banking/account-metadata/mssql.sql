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

--For account metadata feature run the following queries against the openbank_openbankingdb--
IF OBJECT_ID('dbo.OB_ACCOUNT_METADATA', 'U') IS NULL
BEGIN
CREATE TABLE dbo.OB_ACCOUNT_METADATA
(
ACCOUNT_ID varchar(100) NOT NULL,
USER_ID varchar(100) NOT NULL,
METADATA_KEY varchar(100) NOT NULL,
METADATA_VALUE varchar(100) NOT NULL,
LAST_UPDATED_TIMESTAMP timestamp NOT NULL,
CONSTRAINT OB_ACCOUNT_USER_ATTRIBUTE_PK PRIMARY KEY (USER_ID,ACCOUNT_ID,METADATA_KEY)
)
END;
