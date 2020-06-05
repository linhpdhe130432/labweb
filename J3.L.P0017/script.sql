Create database PhotographerLab1

use PhotographerLab1
go



create table Information (
About NVarchar(max) not null,
ShortAbout Nvarchar(100) not null,
ImageAboutUrl varchar(100) not null 
)

insert into Information(About,ShortAbout,ImageAboutUrl)
values(N'Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut
 laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper
  suscipit lobortis nisl ut aliquip ex ea commodo consequat. Duis autem vel eum iriure dolor in hendrerit in vulputate
   velit esse molestie consequat, vel illum dolore eu feugiat nulla facilisis at vero eros et accumsan et iusto odio 
   dignissim qui blandit praesent luptatum zzril delenit augue duis dolore te feugait nulla facilisi.
 Nam liber tempor cum soluta nobis eleifend option congue nihil imperdiet doming id quod mazim',
 N'Lorem ipsum dolor sit amet','girlYellowEye.jpg')

 create table Contact(
 Name nvarchar(100),
 [Address] nvarchar(200),
 City nvarchar(100),
 Country nvarchar(100),
 Telephone varchar(20),
 email varchar(100),
 )

 insert into Contact(Name,[Address],City,Country,Telephone,email)
 values(N'Tùng Dương',N'An Đồng, An Dương',N'Hải Phòng',N'Việt Nam','0988288882','duongdt@photo.com')

 create table Gallery(
 Code int identity(1,1) primary key,
 GalleryName nvarchar(50) not null,
 DescriptionText nvarchar(255) not null,
 DescriptionImageUrl varchar(50) not null
 )

 create table ImageInGallery(
 GalleryCode int  foreign key references Gallery(Code),
 ImageUrl varchar(50),
 ImageCode int identity (1,1)
 primary key(GalleryCode,ImageUrl,ImageCode)
 )

-- insert gellery

 insert into Gallery(GalleryName,DescriptionText,DescriptionImageUrl)
 values(N'Gallery 1',N'Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore
  magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation',
  'boyVioletShirt.jpg')

   insert into Gallery(GalleryName,DescriptionText,DescriptionImageUrl)
 values(N'Gallery 2',N'Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore
  magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation',
  'girlBlackShirt.jpg')

     insert into Gallery(GalleryName,DescriptionText,DescriptionImageUrl)
 values(N'Gallery 3',N'Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore
  magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation',
  'boyBlueEye.jpg')

  insert into Gallery(GalleryName,DescriptionText,DescriptionImageUrl)
 values(N'Gallery 4',N'Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore
  magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation',
  'boyBlueEye.jpg')
  insert into Gallery(GalleryName,DescriptionText,DescriptionImageUrl)
 values(N'Gallery 5',N'Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore
  magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation',
  'boyBlueEye.jpg')

  -- insert image for gallery


  insert into ImageInGallery(GalleryCode,ImageUrl)
  values(1,'boyVioletShirt.jpg')
  insert into ImageInGallery(GalleryCode,ImageUrl)
  values(1,'girlYellowEye.jpg')
    insert into ImageInGallery(GalleryCode,ImageUrl)
  values(1,'girlBlackShirt.jpg')
      insert into ImageInGallery(GalleryCode,ImageUrl)
  values(1,'boyBlueEye.jpg')
      insert into ImageInGallery(GalleryCode,ImageUrl)
  values(1,'boyBrownEye.jpg')
  insert into ImageInGallery(GalleryCode,ImageUrl)
  values(1,'girlInBW.jpg')
      insert into ImageInGallery(GalleryCode,ImageUrl)
  values(1,'girlShortHair.jpg')
      insert into ImageInGallery(GalleryCode,ImageUrl)
  values(1,'girlWithHand.jpg')
      insert into ImageInGallery(GalleryCode,ImageUrl)
  values(1,'dog.jpg')
        insert into ImageInGallery(GalleryCode,ImageUrl)
  values(1,'cat.jpg')


  insert into ImageInGallery(GalleryCode,ImageUrl)
  values(2,'girlBlackShirt.jpg')
      insert into ImageInGallery(GalleryCode,ImageUrl)
  values(2,'boyBlueEye.jpg')
      insert into ImageInGallery(GalleryCode,ImageUrl)
  values(2,'boyBrownEye.jpg')
  insert into ImageInGallery(GalleryCode,ImageUrl)
  values(2,'girlInBW.jpg')
      insert into ImageInGallery(GalleryCode,ImageUrl)
  values(2,'girlShortHair.jpg')

  insert into ImageInGallery(GalleryCode,ImageUrl)
  values(3,'boyBlueEye.jpg')
      insert into ImageInGallery(GalleryCode,ImageUrl)
  values(3,'boyBrownEye.jpg')
  insert into ImageInGallery(GalleryCode,ImageUrl)
  values(3,'girlInBW.jpg')
      insert into ImageInGallery(GalleryCode,ImageUrl)
  values(3,'girlShortHair.jpg')
      insert into ImageInGallery(GalleryCode,ImageUrl)
  values(3,'girlWithHand.jpg')


create procedure getImageGallery(
@pageNumber int,
@pageSize int,
@galleryCode int
)
as
begin
 SELECT * FROM ( 
  SELECT g.ImageUrl,g.ImageCode
  , ROW_NUMBER() OVER(ORDER by ImageCode) as row 
  FROM ImageInGallery g
  where g.GalleryCode = @galleryCode
 ) g WHERE g.row >= (@pageNumber-1)*@pageSize+1 and g.row <= @pageSize*@pageNumber 
end

exec getImageGallery
@pageNumber = 1,
@pageSize = 100,
@galleryCode = 3


select COUNT(ImageCode) from ImageInGallery
where GalleryCode =1

create procedure getGalleryWithPagging(
@pageNumber int,
@pageSize int
)
as
begin
 SELECT * FROM ( 
  SELECT g.Code,g.DescriptionImageUrl,g.DescriptionText,g.GalleryName
  , ROW_NUMBER() OVER(ORDER by Code) as row 
  FROM Gallery g
 ) g WHERE g.row >= (@pageNumber-1)*@pageSize+1 and g.row <= @pageSize*@pageNumber 
end



exec getGalleryWithPagging
@pageNumber = 1,
@pageSize = 3

select  COUNT(Code)  from Gallery



SELECT * FROM ( 
  SELECT g.Code,g.DescriptionImageUrl,g.DescriptionText,g.GalleryName
  , ROW_NUMBER() OVER(ORDER by Code) as row 
  FROM Gallery g
 ) g WHERE g.row >= (1-1)*3+1 and g.row <= 3*1 


 SELECT * FROM ( 
  SELECT g.ImageUrl,g.ImageCode
  , ROW_NUMBER() OVER(ORDER by ImageCode) as row 
  FROM ImageInGallery g
  where g.GalleryCode = 1
 ) g WHERE g.row >= (1-1)*4+1 and g.row <= 1*4 