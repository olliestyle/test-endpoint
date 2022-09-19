create table amortizations(
    uuid uuid primary key ,
    vehicleKindUuid uuid,
    usePeriod int,
    avgPrice decimal,
    totalPrice decimal
);