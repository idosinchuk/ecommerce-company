-- V1__init.sql

-- Create tables
DROP TABLE IF EXISTS prices;

CREATE TABLE PRICES
(
    ID         BIGINT AUTO_INCREMENT PRIMARY KEY,
    BRAND_ID   BIGINT     NOT NULL,
    START_DATE TIMESTAMP(3),
    END_DATE   TIMESTAMP(3),
    PRICE_LIST INTEGER     NOT NULL,
    PRODUCT_ID BIGINT     NOT NULL,
    PRIORITY   INTEGER     NOT NULL,
    PRICE      NUMERIC     NOT NULL,
    CURR       VARCHAR(5)  NOT NULL
);