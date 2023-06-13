package dao.Interfaces;


import dao.Models.Farmstead;
import java.util.List;

public interface IFarmsteadDao extends IDAO<Farmstead> {
    Farmstead create(Farmstead farmstead);
    Farmstead getById(int id);
    List<Farmstead> getAll();
    Farmstead update(Farmstead farmstead);
    int delete(int id);
}

