namespace EditoraCrescer.Infreaestrutura.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class ColocarUrlEmLivros : DbMigration
    {
        public override void Up()
        {
            AddColumn("dbo.Livros", "Capa", c => c.String());
        }
        
        public override void Down()
        {
            DropColumn("dbo.Livros", "Capa");
        }
    }
}
