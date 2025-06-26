ALTER TABLE `account`
CHANGE COLUMN `created_at` `created_at` TIMESTAMP NOT NULL ,
CHANGE COLUMN `modified_at` `modified_at` TIMESTAMP NULL DEFAULT NULL ;

ALTER TABLE `customers`
CHANGE COLUMN `created_at` `created_at` TIMESTAMP NOT NULL ,
CHANGE COLUMN `modified_at` `modified_at` TIMESTAMP NULL DEFAULT NULL ;

ALTER TABLE `account`
ADD UNIQUE INDEX `account_number_UNIQUE` (`account_number` ASC) VISIBLE;


ALTER TABLE `accounts`.`account`
ADD COLUMN `balance` DECIMAL NOT NULL DEFAULT 0.0 AFTER `account_number`;


