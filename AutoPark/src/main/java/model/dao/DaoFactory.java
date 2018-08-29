package model.dao;

import model.dao.Impl.JDBCDaoFactory;

public abstract class DaoFactory {
    private static DaoFactory daoFactory;

    public abstract AdminDao createAdminDao();
    public abstract DriverDao createDriverDao();
    public abstract RouteDao createRouteDao();
    public abstract CarDao createCarDao();
    public abstract AppointmentDao createAppointmentDao();

    public static DaoFactory getInstance(){
        if( daoFactory == null ) {
            synchronized (DaoFactory.class) {
                if(daoFactory == null) {
                    DaoFactory temp = new JDBCDaoFactory();
                    daoFactory = temp;
                }
            }
        }
        return daoFactory;
    }

	
}